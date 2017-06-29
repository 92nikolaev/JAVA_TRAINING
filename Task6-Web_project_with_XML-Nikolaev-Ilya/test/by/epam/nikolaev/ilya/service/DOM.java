package by.epam.nikolaev.ilya.service;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.junit.Test;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.service.iml.DeviceDOMParserService;

public class DOM {
static{PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);}
	
	final static Logger logger = Logger.getLogger(DOM.class);

	@Test
	public void test() {
		DeviceDOMParserService parserService = new DeviceDOMParserService();
		ArrayList<Device> devices = parserService.getDevices();
		for (int i = 0; i < devices.size(); i++) {
			logger.info(devices.get(i).getName());
			logger.info(devices.get(i).getId());
			logger.info(devices.get(i).getPrice().getValue());
			logger.info(devices.get(i).getPrice().getCurrency().toString());
		}
		assertEquals(4, devices.size());
		
	}

}
