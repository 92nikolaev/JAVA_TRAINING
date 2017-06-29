package by.epam.nikolaev.ilya.service;



import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import by.epam.nikolaev.ilya.service.iml.DeviceSAXParserService;

public class SAX {

	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException {
		DeviceSAXParserService deviceService = new DeviceSAXParserService();
		assertEquals(4, deviceService.getDevices().size());
	}

}
