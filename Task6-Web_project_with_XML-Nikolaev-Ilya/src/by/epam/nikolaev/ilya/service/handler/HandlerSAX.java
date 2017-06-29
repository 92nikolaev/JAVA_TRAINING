package by.epam.nikolaev.ilya.service.handler;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.bean.Devices;
import by.epam.nikolaev.ilya.bean.Origin;
import by.epam.nikolaev.ilya.bean.Port;
import by.epam.nikolaev.ilya.bean.Price;
import by.epam.nikolaev.ilya.bean.Type;
import by.epam.nikolaev.ilya.bean.TypePort;

public class HandlerSAX extends DefaultHandler {
	public static final String DEVICES_TAG = "dev:devices";
	public static final String DEVICE_TAG = "dev:device";
	public static final String NAME_TAG = "dst:name";
	public static final String ORIGIN_TAG = "dev:origin";
	public static final String PRICE_TAG = "dev:price";
	public static final String TYPE_TAG = "dev:type";
	public static final String IS_PERIPHERAL_TAG = "dst:isPeripheral";
	public static final String ENERGY_CONSUMPTION_TAG = "dst:energyConsumption";
	public static final String HAS_COOLER_TAG = "dst:hasCooler";
	public static final String DEVICES_GROUP_TAG = "dev:devicesGroup";
	public static final String PROT_TAG = "dev:port";
	public static final String IS_CRITICAL_TAG = "dst:isCritical";
	
	
	public static final String DEVICE_ID_ATTRIBUTE = "dev:id";
	public static final String ORIGIN_COUNTRY_ATTRIBUTE = "dev:country";
	public static final String PRICE_CURRENCY_ATTRIBUTE = "dev:currency";
	public static final String PROT_ID_ATTRIBUTE = "dev:id";
	
	private Devices devices;
	private Device device;
	private Origin origin;
	private Port port;
	private Price price;
	private Type type;
	private String currentElement;
	
	public Devices getDevices() {
		return devices;
	}

	public void startDocument() {
		System.out.println("Strating document");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentElement=qName;
		
		switch (currentElement) {
			case DEVICES_TAG:{
				devices = new Devices();
			}break;
			
			case DEVICE_TAG:{
				device = new Device();
				device.setId(new BigInteger(attributes.getValue(DEVICE_ID_ATTRIBUTE)));
			}break;
			case ORIGIN_TAG:{
				origin = new Origin();
				origin.setCountry(attributes.getValue(ORIGIN_COUNTRY_ATTRIBUTE));
				device.setOrigin(origin);
			}break;
			case PRICE_TAG:{
				price = new Price();
				price.setCurrency(attributes.getValue(PRICE_CURRENCY_ATTRIBUTE));
				device.setPrice(price);
			}break;
			case TYPE_TAG:{
				type = new Type();
				device.setType(type);
			}break;
			case PROT_TAG:{
				port = new Port();
				port.setId(new BigInteger(attributes.getValue(PROT_ID_ATTRIBUTE)));
				type.setPort(port);
			}
			
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String text = new String(ch, start, length);
		
		if(text.contains("<")|| currentElement == null){
			return;
		}
		
		switch (currentElement) {
			case NAME_TAG:{
				device.setName(text);
			}break;
			case ORIGIN_TAG:{
				origin.setValue(text);
			}break;
			case PRICE_TAG:{
				price.setValue(new BigDecimal(text));
			}break;
			case IS_PERIPHERAL_TAG:{
				type.setIsPeripheral(Boolean.valueOf(text));
			}break;
			case ENERGY_CONSUMPTION_TAG:{
				type.setEnergyConsumption(new BigInteger(text));
			}break;
			case HAS_COOLER_TAG:{
				type.setHasCooler(Boolean.valueOf(text));
			}break;
			case DEVICES_GROUP_TAG:{
				type.setDevicesGroup(text);
			}break;
			case PROT_TAG:{
				port.setValue(TypePort.valueOf(text));
			}break;
			case IS_CRITICAL_TAG:{
				device.setIsCritical(Boolean.valueOf(text));
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
			case DEVICE_TAG:{
				devices.getDevice().add(device);
				device = null;
			}break;

		}
		currentElement = null;
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("XML parsing is comleted");
	}
	
}
