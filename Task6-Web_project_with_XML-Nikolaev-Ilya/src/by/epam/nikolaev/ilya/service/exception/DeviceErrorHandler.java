package by.epam.nikolaev.ilya.service.exception;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class DeviceErrorHandler extends DefaultHandler{
	
	// создание регистратора ошибок для пакета by.epam.nikolaev.ilya.service
	
	private Logger logger = Logger.getLogger("by.epam.nikolaev.ilya.service");
	
	// установка файла и формата вывода ошибок 
	public DeviceErrorHandler(String log) throws IOException {
		logger.addAppender(new FileAppender(new SimpleLayout(), log));
	}
	public void warning(SAXParseException e) {
		logger.warn(getLineAddress(e) + "-" + e.getMessage());
	}
	public void error(SAXParseException e) {
		logger.error(getLineAddress(e) + " - " + e.getMessage()); 
	}
	public void fatalError(SAXParseException e) {
		logger.fatal(getLineAddress(e) + " - " + e.getMessage());
	} 
	private String getLineAddress(SAXParseException e) {
		// определение строки и столбца ошибки 
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
	

}
