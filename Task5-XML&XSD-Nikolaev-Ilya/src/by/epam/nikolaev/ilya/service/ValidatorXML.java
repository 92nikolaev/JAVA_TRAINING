package by.epam.nikolaev.ilya.service;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import by.epam.nikolaev.ilya.service.handler.DeviceErrorHandler;

public class ValidatorXML {
	
	public static boolean validationXML(String pathXML, String pathSchema){
		boolean result = false; 
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		File schemaLocation = new File(pathSchema);
		try{
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(pathXML);
			DeviceErrorHandler deviceErrorHandler = new DeviceErrorHandler("log/log.txt");
			validator.setErrorHandler(deviceErrorHandler);
			validator.validate(source);
			result = deviceErrorHandler.isResult();
		}catch (SAXException e) {
			 System.err.print("validation " + pathXML +  " is not valid because " + e.getMessage());
		}catch (IOException e) {
			 System.err.print(pathXML + " is not valid because " + e.getMessage()); 
		}
		return result;
		
	}
	

}
