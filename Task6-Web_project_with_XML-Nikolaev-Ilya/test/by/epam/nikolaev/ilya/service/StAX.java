package by.epam.nikolaev.ilya.service;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.service.iml.DeviceStAXParserService;

public class StAX {
	static{PropertyConfigurator.configure(NameParameter.PROPERTY_CONFIG_LOG4J);}
	final static Logger logger = Logger.getLogger(DOM.class);
	@Test
	public void test() {
		DeviceStAXParserService deviceStAXParserService = new DeviceStAXParserService();
		ArrayList<Device> devices = deviceStAXParserService.getDevices();
		for (Device device : devices) {
			logger.info(device.getName());
			logger.info(device.getId());
			logger.info(device.getPrice().getValue());
			logger.info(device.getPrice().getCurrency().toString());
		}
		assertEquals(4, devices.size());
	}

}
