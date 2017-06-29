package by.epam.nikolaev.ilya.service.impl.reader.tour;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.bean.impl.tour.ExcursionRestTour;
import by.epam.nikolaev.ilya.bean.impl.tour.ExcursionTour;
import by.epam.nikolaev.ilya.bean.impl.tour.SeaTour;
import by.epam.nikolaev.ilya.bean.impl.tour.TherapyTour;
import by.epam.nikolaev.ilya.command.NameParameter;
import by.epam.nikolaev.ilya.service.ITourGetter;


public class TourReaderJSON implements ITourGetter {
	static{PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);}
	
	final static Logger logger = Logger.getLogger(TourReaderJSON.class);
	private static TourReaderJSON instanceJSON;
	private Gson gson = new Gson(); 
	private BufferedReader bufferedReader;
	
	
	private TourReaderJSON() {	}

	public static TourReaderJSON getInstance(){
		return (instanceJSON == null)?new TourReaderJSON():instanceJSON;
	}
	@Override
	public List<ExcursionTour> getExcursionTour() {
		ArrayList<ExcursionTour> listExTour = new ArrayList<>();
		try {
			bufferedReader = new BufferedReader(new FileReader(NameParameter.FILE_EXCURSION));
			StringBuilder templExTour = new StringBuilder();
			while(bufferedReader.ready()){
				templExTour.append(bufferedReader.readLine());	
			}
			String exTour = templExTour.toString();
			ExcursionTour[] templListExTour = gson.fromJson(exTour, ExcursionTour[].class);
			Collections.addAll(listExTour, templListExTour);
			return listExTour;
		} catch (FileNotFoundException e) {
			logger.error(NameParameter.FILE_NOT_FOUIND_EX, e);
			
		} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				logger.error(NameParameter.IO_EXCEPTION, e);
			}
		}
		return listExTour;
	}

	@Override
	public List<ExcursionRestTour> getExcursionRestTour() {
		ArrayList<ExcursionRestTour> listExRestTour = new ArrayList<>();
		try {
			bufferedReader = new BufferedReader(new FileReader(NameParameter.FILE_EXCURSION_REST));
			StringBuilder templExRestTour = new StringBuilder();
			while(bufferedReader.ready()){
				templExRestTour.append(bufferedReader.readLine());	
			}
			String exRestTour = templExRestTour.toString();
			ExcursionRestTour[] templListExRestTour = gson.fromJson(exRestTour, ExcursionRestTour[].class);
			Collections.addAll(listExRestTour, templListExRestTour);
			return listExRestTour;
		} catch (FileNotFoundException e) {
			logger.error(NameParameter.FILE_NOT_FOUIND_EX, e);
			
		} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				logger.error(NameParameter.IO_EXCEPTION, e);
			}
		}
		return listExRestTour;
	}

	@Override
	public List<SeaTour> getSeaTour() {
		ArrayList<SeaTour> listSeaTour = new ArrayList<>();
		try {
			bufferedReader = new BufferedReader(new FileReader(NameParameter.FILE_SEA));
			StringBuilder templSeaTour = new StringBuilder();
			while(bufferedReader.ready()){
				templSeaTour.append(bufferedReader.readLine());	
			}
			String seaTour = templSeaTour.toString();
			SeaTour[] templListSeaTour = gson.fromJson(seaTour, SeaTour[].class);			
			Collections.addAll(listSeaTour, templListSeaTour);
			return listSeaTour;
		} catch (FileNotFoundException e) {
			logger.error(NameParameter.FILE_NOT_FOUIND_EX, e);
			
		} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				logger.error(NameParameter.IO_EXCEPTION, e);
			}
		}
		return listSeaTour;
	}

	@Override
	public List<TherapyTour> getTherapyTour() {
		ArrayList<TherapyTour> ListTherapyTour = new ArrayList<>();
		try {
			bufferedReader = new BufferedReader(new FileReader(NameParameter.FILE_THERAPY));
			StringBuilder templTherapyTour = new StringBuilder();
			while(bufferedReader.ready()){
				templTherapyTour.append(bufferedReader.readLine());	
			}
			String therapyTour = templTherapyTour.toString();
			TherapyTour[] templListTherapyTour = gson.fromJson(therapyTour, TherapyTour[].class);			
			Collections.addAll(ListTherapyTour, templListTherapyTour);
			return ListTherapyTour;
		} catch (FileNotFoundException e) {
			logger.error(NameParameter.FILE_NOT_FOUIND_EX, e);
			
		} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				logger.error(NameParameter.IO_EXCEPTION, e);
			}
		}
		return ListTherapyTour;
	}

	@Override
	public List<Tour> getAllTour() {
		ArrayList<Tour> listTour = new ArrayList<>();
		listTour.addAll(getExcursionTour());
		listTour.addAll(getExcursionRestTour());
		listTour.addAll(getSeaTour());
		listTour.addAll(getTherapyTour());
		return listTour;		
		}
	

}
