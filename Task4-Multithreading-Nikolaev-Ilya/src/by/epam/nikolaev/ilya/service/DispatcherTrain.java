package by.epam.nikolaev.ilya.service;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import by.epam.nikolaev.ilya.bean.RailwayPlatform;
import by.epam.nikolaev.ilya.bean.Train;
public class DispatcherTrain implements Runnable {
	
	static{PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);}
	
	final static Logger logger = Logger.getLogger(DispatcherTrain.class);
	
	private Train train;
	private RailwayPlatform platform;
	
	
	public DispatcherTrain(Train train, RailwayPlatform platform) {
		super();
		this.train = train;
		this.platform = platform;
	}


	@Override
	public void run() {
		logger.info(NameParameter.TRAIN_ARRIVE + train.getName());
			try {
				platform.getSEMAPHORE().acquire();
				int trackNumber = -1;
				platform.getLock().lock();
				////Ищем свободное место
				try{
					for (int i = 0; i < platform.getTracks().size(); i++) {
						// есле путь пуст пот едем на него
						if(!platform.getTracks().get(i).isEmpty()){
							platform.getTracks().get(i).setEmpty(true);
							trackNumber = i;
							logger.info(NameParameter.TRAIN_ARRIVE_PLATFORM + trackNumber +" " + train.getName());
							break;
						}
					}
					switch (trackNumber) {
					case 0	: platform.setTimeWaitFirstTrain(train.getTimeStop());
						Thread time = new Thread(new Runnable() {
							int startTime = train.getTimeStop();
							@Override
							public void run() {
								for (int i = 0; i < train.getTimeStop(); i++) {
									platform.setTimeWaitFirstTrain(startTime--);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {
										logger.error(e);
									}
								}
								
							}
						});
						time.start();
						break;
					case 1	: platform.setTimeWaitSecondTrain(train.getTimeStop());
						Thread time2 = new Thread(new Runnable() {
						int startTime = train.getTimeStop();
						@Override
						public void run() {
							for (int i = 0; i < train.getTimeStop(); i++) {
								platform.setTimeWaitSecondTrain(startTime--);
								try {
									Thread.sleep(80);
								} catch (InterruptedException e) {
									logger.error(e);
								}
							}
							
						}
					});
					time2.start();
						break;
					}
					Thread.sleep(1000);
					if(train.isHuman()){
						if(platform.getTimeWaitFirstTrain()>platform.getTimeWaitSecondTrain()){
							if(platform.getTimeWaitSecondTrain()>300){
								logger.info(platform.getTimeWaitSecondTrain() + NameParameter.REMAINING_TIME + NameParameter.SIT);
							}else {
								logger.info(platform.getTimeWaitSecondTrain() + NameParameter.REMAINING_TIME + NameParameter.NOT_SIT);
							}	
						}else{
							if(platform.getTimeWaitFirstTrain()> 300){
								logger.info(platform.getTimeWaitSecondTrain() + NameParameter.REMAINING_TIME + NameParameter.SIT);	
							}else{
								logger.info(platform.getTimeWaitSecondTrain() + NameParameter.REMAINING_TIME + NameParameter.NOT_SIT);
							}
						}
					}
				}finally {
					platform.getLock().unlock();
				}
				Thread.sleep(train.getTimeStop());
				
				platform.getLock().lock();
				try {
					platform.getTracks().get(trackNumber).setEmpty(false);// освобождаем место
				} finally {
					platform.getLock().unlock();;
				}
				platform.getSEMAPHORE().release();
				logger.info(NameParameter.TRAIN_LEAVE + train.getName() + trackNumber);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		
	}
	
	
	
	
}
