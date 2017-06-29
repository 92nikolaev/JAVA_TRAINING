package by.epam.nikolaev.ilya.service.handler;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class DeviceErrorHandler extends DefaultHandler{
	private boolean result = true;;
	// �������� ������������ ������ ��� ������ by.epam.nikolaev.ilya.service
	
	private Logger logger = Logger.getLogger("by.epam.nikolaev.ilya.service");
	
	// ��������� ����� � ������� ������ ������ 
	public DeviceErrorHandler(String log) throws IOException {
		result = false;
		logger.addAppender(new FileAppender(new SimpleLayout(), log));
	}
	public void warning(SAXParseException e) {
		result = false;
		logger.warn(getLineAddress(e) + "-" + e.getMessage());
	}
	public void error(SAXParseException e) {
		result = false;
		logger.error(getLineAddress(e) + " - " + e.getMessage()); 
	}
	public void fatalError(SAXParseException e) {
		result = false;
		logger.fatal(getLineAddress(e) + " - " + e.getMessage());
	} 
	private String getLineAddress(SAXParseException e) {
		// ����������� ������ � ������� ������ 
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
	public boolean isResult() {
		return result;
	}
	
	
}
