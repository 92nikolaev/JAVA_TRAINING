package by.epam.nikolaev.ilya.service.loader.text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import by.epam.nikolaev.ilya.service.NameParameter;


public class LoaderText {
	static{PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);}
	final static Logger logger = Logger.getLogger(LoaderText.class);
	private static String allText;
	private static BufferedReader bufferedReader;
	
	public static String getAlltext(){
		try {
			bufferedReader = new BufferedReader(new FileReader(NameParameter.FILE_BOOK));
			StringBuilder text = new StringBuilder();
			while(bufferedReader.ready()){
				text.append(bufferedReader.readLine() + NameParameter.NEW_LINE);
			}
			allText = text.toString();
		} catch (FileNotFoundException e) {
			logger.error(NameParameter.FILE_NOT_FOUIND_EX, e);
		} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		}finally {
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					logger.error(NameParameter.IO_EXCEPTION, e);
				}
			}
		}
		
		return allText;
	}

}
