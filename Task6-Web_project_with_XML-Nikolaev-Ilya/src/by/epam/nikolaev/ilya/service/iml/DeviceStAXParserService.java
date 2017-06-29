package by.epam.nikolaev.ilya.service.iml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.bean.Origin;
import by.epam.nikolaev.ilya.bean.Port;
import by.epam.nikolaev.ilya.bean.Price;
import by.epam.nikolaev.ilya.bean.Type;
import by.epam.nikolaev.ilya.bean.TypePort;


public class DeviceStAXParserService {
	private final String DEVICE_SIMPLE_TYPE_URI = "http://www.epam.by/deviceSimpleTypes";
	private final String DEVICES_URI = "http://www.epam.by/devices";
	private final String XML_PATH = "C:\\Users\\Dom\\workspace2\\Task6-Nikolaev-Ilya\\xml\\device.xml";
	
	public static final String DEVICES_TAG = "devices";
	public static final String DEVICE_TAG = "device";
	public static final String NAME_TAG = "name";
	public static final String ORIGIN_TAG = "origin";
	public static final String PRICE_TAG = "price";
	public static final String TYPE_TAG = "type";
	public static final String IS_PERIPHERAL_TAG = "isPeripheral";
	public static final String ENERGY_CONSUMPTION_TAG = "energyConsumption";
	public static final String HAS_COOLER_TAG = "hasCooler";
	public static final String DEVICES_GROUP_TAG = "devicesGroup";
	public static final String PROT_TAG = "port";
	public static final String IS_CRITICAL_TAG = "isCritical";
	
	private Device currentDevice;
	private ArrayList<Device> devices;
	private boolean name;
	private boolean isCritical;
	private boolean isPeripherals;
	private boolean hasCooler;
	private boolean energyConsumption;
	private boolean origin;
	private boolean price;
	private boolean port;
	private boolean devicesGroup;
	
	

	public ArrayList<Device> getDevices()  {
		devices = new ArrayList<>();
		XMLEventReader eventReader = init();
		while(eventReader.hasNext()){
			XMLEvent event = null;
			try {
				event = eventReader.nextEvent();
			} catch (XMLStreamException e) {
				e.printStackTrace();
			};
			switch (event.getEventType()) {
			case XMLStreamConstants.START_ELEMENT:{
				startElement(event.asStartElement());				
			}break;
			case XMLStreamConstants.CHARACTERS:{
				characters(event.asCharacters());
			}
			
			}
		}
		return devices;
	}

	private XMLEventReader init() {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = null;
		try {
			eventReader = inputFactory.createXMLEventReader(new FileReader(XML_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return eventReader;
	}
	
	private void startElement(StartElement element) {
		String localName = element.getName().getLocalPart();
		String uri = element.getName().getNamespaceURI();
		@SuppressWarnings("unchecked")
		Iterator<Attribute> iterator = element.getAttributes();
		
		if (localName.equalsIgnoreCase(NAME_TAG) && uri.equalsIgnoreCase(DEVICE_SIMPLE_TYPE_URI))
			name = true;
		else if (localName.equalsIgnoreCase(TYPE_TAG) && uri.equalsIgnoreCase(DEVICES_URI))
			currentDevice.setType(new Type());
		else if (localName.equalsIgnoreCase(IS_CRITICAL_TAG) && uri.equalsIgnoreCase(DEVICE_SIMPLE_TYPE_URI))
			isCritical = true;
		else if (localName.equalsIgnoreCase(IS_PERIPHERAL_TAG) && uri.equalsIgnoreCase(DEVICE_SIMPLE_TYPE_URI))
			isPeripherals = true;
		else if (localName.equalsIgnoreCase(ENERGY_CONSUMPTION_TAG) && uri.equalsIgnoreCase(DEVICE_SIMPLE_TYPE_URI))
			energyConsumption = true;
		else if (localName.equalsIgnoreCase(HAS_COOLER_TAG) && uri.equalsIgnoreCase(DEVICE_SIMPLE_TYPE_URI))
			hasCooler = true;
		else if (localName.equalsIgnoreCase(DEVICES_GROUP_TAG) && uri.equalsIgnoreCase(DEVICES_URI))
			devicesGroup = true;
		else if (localName.equalsIgnoreCase(PROT_TAG) && uri.equalsIgnoreCase(DEVICES_URI)) {
			port = true;
			Port pt = new Port();
			pt.setId(new BigInteger(iterator.next().getValue()));
			currentDevice.getType().setPort(pt);
		} else if (localName.equalsIgnoreCase(ORIGIN_TAG) && uri.equalsIgnoreCase(DEVICES_URI)) {
			origin = true;
			Origin or = new Origin();
			or.setCountry(iterator.next().getValue());
			currentDevice.setOrigin(or);
		} else if (localName.equalsIgnoreCase(DEVICE_TAG) && uri.equalsIgnoreCase(DEVICES_URI)) {
			currentDevice = new Device();
			devices.add(currentDevice);
			currentDevice.setId(new BigInteger(iterator.next().getValue()));
		}else if (localName.equalsIgnoreCase(PRICE_TAG) && uri.equalsIgnoreCase(DEVICES_URI)){
			price = true;
			Price price = new Price();
			price.setCurrency(iterator.next().getValue());
			currentDevice.setPrice(price);
		}
			
	}
	private void characters(Characters characters) {
		if (name) {
			currentDevice.setName(characters.getData());
			name = false;
		} else if (isCritical) {
			currentDevice.setIsCritical(new Boolean(characters.getData()));
			isCritical = false;
		} else if (isPeripherals) {
			currentDevice.getType().setIsPeripheral(new Boolean(characters.getData()));
			isPeripherals = false;
		} else if (hasCooler) {
			currentDevice.getType().setHasCooler(new Boolean(characters.getData()));
			hasCooler = false;
		} else if (energyConsumption) {
			currentDevice.getType().setEnergyConsumption(new BigInteger(characters.getData()));
			energyConsumption = false;
		} else if (origin) {
			currentDevice.getOrigin().setValue(characters.getData());
			origin = false;
		} else if (price) {
			currentDevice.getPrice().setValue(new BigDecimal(characters.getData()));
			price = false;
		} else if (port) {
			currentDevice.getType().getPort().setValue(TypePort.valueOf(characters.getData()));
			port = false;
		} else if (devicesGroup) {
			currentDevice.getType().setDevicesGroup(characters.getData());
			devicesGroup = false;
		}
	}
}	
