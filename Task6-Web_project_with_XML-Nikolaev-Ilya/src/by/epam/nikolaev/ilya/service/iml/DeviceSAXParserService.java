package by.epam.nikolaev.ilya.service.iml;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.bean.Devices;
import by.epam.nikolaev.ilya.service.handler.HandlerSAX;

public class DeviceSAXParserService {
	private final String XML_PATH = "C:\\Users\\Dom\\workspace2\\Task6-Nikolaev-Ilya\\xml\\device.xml";

	public ArrayList<Device> getDevices() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		HandlerSAX handlerSAX = new HandlerSAX();
		xmlReader.setContentHandler(handlerSAX);
		xmlReader.parse(XML_PATH);
		Devices devices = handlerSAX.getDevices();
		return  new ArrayList<Device>(devices.getDevice());
	}
}
