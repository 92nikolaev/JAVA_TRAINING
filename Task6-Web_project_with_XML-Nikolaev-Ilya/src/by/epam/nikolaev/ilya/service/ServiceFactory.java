package by.epam.nikolaev.ilya.service;

import by.epam.nikolaev.ilya.service.iml.DeviceDOMParserService;
import by.epam.nikolaev.ilya.service.iml.DeviceSAXParserService;
import by.epam.nikolaev.ilya.service.iml.DeviceStAXParserService;

public class ServiceFactory {
	private static ServiceFactory instance;
	
	DeviceSAXParserService deviceSAXParserService = new DeviceSAXParserService();
	DeviceDOMParserService deviceDOMParserService = new DeviceDOMParserService();
	DeviceStAXParserService deviceStAXParserService = new DeviceStAXParserService();
	
	private ServiceFactory() {
	}
	public static ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}
	
	public DeviceSAXParserService getDeviceSAXParserService() {
		return deviceSAXParserService;
	}
	public DeviceDOMParserService getDeviceDOMParserService() {
		return deviceDOMParserService;
	}
	public DeviceStAXParserService getDeviceStAXParserService() {
		return deviceStAXParserService;
	}
	

}
