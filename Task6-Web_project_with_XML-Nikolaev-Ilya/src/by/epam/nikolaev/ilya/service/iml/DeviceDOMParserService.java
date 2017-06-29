package by.epam.nikolaev.ilya.service.iml;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.nikolaev.ilya.bean.Device;
import by.epam.nikolaev.ilya.bean.Origin;
import by.epam.nikolaev.ilya.bean.Port;
import by.epam.nikolaev.ilya.bean.Price;
import by.epam.nikolaev.ilya.bean.Type;
import by.epam.nikolaev.ilya.bean.TypePort;

public class DeviceDOMParserService {
	private final String DEVICE_SIMPLE_TYPE_URI = "http://www.epam.by/deviceSimpleTypes";
	private final String DEVICES_URI = "http://www.epam.by/devices";
	private final String XML_PATH = "C:\\Users\\Dom\\workspace2\\Task6-Nikolaev-Ilya\\xml\\device.xml";
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
	
	public static final String DEVICE_ID_ATTRIBUTE = "id";
	public static final String ORIGIN_COUNTRY_ATTRIBUTE = "country";
	public static final String PRICE_CURRENCY_ATTRIBUTE = "currency";
	public static final String PROT_ID_ATTRIBUTE = "id";

	public ArrayList<Device> getDevices() {
		ArrayList<Device> devices = new ArrayList<>();
		NodeList deviceList = getDeviceNodes();
		for (int i = 0; i < deviceList.getLength(); i++) {
			Element currentElement = (Element) deviceList.item(i);
			devices.add(getDevice(currentElement));
		}
		return devices;
	}
	
	private NodeList getDeviceNodes() {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setNamespaceAware(true);
		Document document = null;;
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			document = builder.parse(XML_PATH);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return document.getDocumentElement().getElementsByTagNameNS(DEVICES_URI, DEVICE_TAG);
	}

	private Device getDevice(Element currentElement) {
		Device device = new Device();
		device.setId(new BigInteger(currentElement.getAttributeNS(DEVICES_URI, DEVICE_ID_ATTRIBUTE)));
		device.setName(getNodeVolue(currentElement, DEVICE_SIMPLE_TYPE_URI, NAME_TAG));
		device.setOrigin(getOrigin(currentElement));
		device.setPrice(getPrice(currentElement));
		device.setType(getType(currentElement));
		device.setIsCritical(new Boolean(getNodeVolue(currentElement, DEVICE_SIMPLE_TYPE_URI, IS_CRITICAL_TAG)));
		return device;
	}

	

	private Type getType(Element currentElement) {
		NodeList list = currentElement.getElementsByTagNameNS(DEVICES_URI, TYPE_TAG);
		Element typeElement = (Element) list.item(0);
		Type type = new Type();
		type.setHasCooler(new Boolean(getNodeVolue(typeElement, DEVICE_SIMPLE_TYPE_URI, IS_PERIPHERAL_TAG)));
		type.setEnergyConsumption(new BigInteger(getNodeVolue(typeElement, DEVICE_SIMPLE_TYPE_URI, ENERGY_CONSUMPTION_TAG)));
		type.setHasCooler(new Boolean(getNodeVolue(typeElement, DEVICE_SIMPLE_TYPE_URI, HAS_COOLER_TAG)));
		type.setDevicesGroup(getNodeVolue(typeElement, DEVICES_URI, DEVICES_GROUP_TAG));
		type.setPort(getPort(typeElement));
		return type;
	}

	private Port getPort(Element typeElement) {
		NodeList list = typeElement.getElementsByTagNameNS(DEVICES_URI, PROT_TAG);
		Element portElement = (Element) list.item(0);
		Port port = new Port();
		port.setId(new BigInteger(portElement.getAttributeNS(DEVICES_URI, PROT_ID_ATTRIBUTE)));
		port.setValue(TypePort.valueOf(portElement.getTextContent()));
		return port;
	}

	private Price getPrice(Element currentElement) {
		NodeList list = currentElement.getElementsByTagNameNS(DEVICES_URI, PRICE_TAG);
		Element priceElement = (Element) list.item(0);
		Price price = new Price();
		price.setCurrency(priceElement.getAttributeNS(DEVICES_URI, PRICE_CURRENCY_ATTRIBUTE));
		price.setValue(new BigDecimal(priceElement.getTextContent()));
		return price;
	}

	private String getNodeVolue(Element element, String nameSpace, String nameTag) {
		NodeList childNode = element.getElementsByTagNameNS(nameSpace, nameTag);
		return  childNode.item(0).getTextContent();
	}
	private Origin getOrigin(Element currentElement) {
		NodeList list = currentElement.getElementsByTagNameNS(DEVICES_URI, ORIGIN_TAG);
		Element originElement = (Element) list.item(0);
		Origin origin = new Origin();
		origin.setCountry(originElement.getAttributeNS(DEVICES_URI, ORIGIN_COUNTRY_ATTRIBUTE));
		origin.setValue(originElement.getTextContent());
		return origin;
	}

}

