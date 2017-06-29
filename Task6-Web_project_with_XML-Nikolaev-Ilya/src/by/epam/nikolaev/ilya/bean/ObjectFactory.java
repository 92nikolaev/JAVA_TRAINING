//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.17 at 03:59:39 PM MSK 
//


package by.epam.nikolaev.ilya.bean;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.epam.nikolaev.ilya.bean package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnergyConsumption_QNAME = new QName("http://www.epam.by/deviceSimpleTypes", "energyConsumption");
    private final static QName _DevicesGroup_QNAME = new QName("http://www.epam.by/devices", "devicesGroup");
    private final static QName _HasCooler_QNAME = new QName("http://www.epam.by/deviceSimpleTypes", "hasCooler");
    private final static QName _IsPeripheral_QNAME = new QName("http://www.epam.by/deviceSimpleTypes", "isPeripheral");
    private final static QName _IsCritical_QNAME = new QName("http://www.epam.by/deviceSimpleTypes", "isCritical");
    private final static QName _Name_QNAME = new QName("http://www.epam.by/deviceSimpleTypes", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.epam.nikolaev.ilya.bean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Port }
     * 
     */
    public Port createPort() {
        return new Port();
    }

    /**
     * Create an instance of {@link Devices }
     * 
     */
    public Devices createDevices() {
        return new Devices();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link Origin }
     * 
     */
    public Origin createOrigin() {
        return new Origin();
    }

    /**
     * Create an instance of {@link Price }
     * 
     */
    public Price createPrice() {
        return new Price();
    }

    /**
     * Create an instance of {@link Type }
     * 
     */
    public Type createType() {
        return new Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/deviceSimpleTypes", name = "energyConsumption")
    public JAXBElement<BigInteger> createEnergyConsumption(BigInteger value) {
        return new JAXBElement<BigInteger>(_EnergyConsumption_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/devices", name = "devicesGroup")
    public JAXBElement<String> createDevicesGroup(String value) {
        return new JAXBElement<String>(_DevicesGroup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/deviceSimpleTypes", name = "hasCooler")
    public JAXBElement<Boolean> createHasCooler(Boolean value) {
        return new JAXBElement<Boolean>(_HasCooler_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/deviceSimpleTypes", name = "isPeripheral")
    public JAXBElement<Boolean> createIsPeripheral(Boolean value) {
        return new JAXBElement<Boolean>(_IsPeripheral_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/deviceSimpleTypes", name = "isCritical")
    public JAXBElement<Boolean> createIsCritical(Boolean value) {
        return new JAXBElement<Boolean>(_IsCritical_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.epam.by/deviceSimpleTypes", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

}
