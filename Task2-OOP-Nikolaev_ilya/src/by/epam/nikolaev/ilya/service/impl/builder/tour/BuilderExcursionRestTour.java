package by.epam.nikolaev.ilya.service.impl.builder.tour;

import org.apache.log4j.Logger;

import by.epam.nikolaev.ilya.bean.impl.tour.ExcursionRestTour;

public class BuilderExcursionRestTour extends BuilderExcursionTour{
	final static Logger logger = Logger.getLogger(BuilderExcursionRestTour.class);
	private String resort;
	private String hotel;
	
	
	
	public BuilderExcursionRestTour setResort(String resort){
		this.resort = resort;
		return this;
	}
	public BuilderExcursionRestTour setHotel(String hotel){
		this.hotel = hotel;
		return this;
	}
	
	public String getResort() {
		return resort;
	}
	public String getHotel() {
		return hotel;
	}
	
	@Override
	public ExcursionRestTour build(){
		logger.info(new ExcursionRestTour(this).toString());
		return new ExcursionRestTour(this);
	}
	
	

}
