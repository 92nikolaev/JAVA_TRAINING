package by.epam.task1.helper;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Helper {
	static{
		PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);
	}
	final static Logger logger = Logger.getLogger(Helper.class);
	
	public static Collection<Object[]> loadingTestData(String path) {
		logger.info(NameParameter.METHOD_DATA_TEST + path);
		ArrayList<Object[]> data = new ArrayList<>();
		JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject)parser.parse(new FileReader(path));
			Object[] keys = jsonObject.keySet().toArray();
			for (Object object : keys) {
			JSONObject json = (JSONObject) jsonObject.get(object);
			data.add(new Object[]{json});
			}
			logger.info(NameParameter.RETURN_COLLECT);
			return data;
		} catch (FileNotFoundException e) {
			logger.error(NameParameter.FILE_NOT_FOUIND_EX, e);
			} catch (IOException e) {
			logger.error(NameParameter.IO_EXCEPTION, e);
		} catch (ParseException e) {
			logger.error(NameParameter.PARSE_EX, e);
		}
		return data;
	}
}

