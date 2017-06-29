# Task 5 XML & XSD
It is necessary to create an xml-file storing information about objects of a certain domain. To validate the resulting xml-file, it is necessary to develop the corresponding xsd schema.

General requirements for the assignment:
1. When developing XSD, use:
	 simple and complex types,
	 enumerated,
	 templates and limit values,
	 It is mandatory to use attributes and type ID.
2. Validate the XML document using XSD.

Optional requirements for the job:
1. Generate the Java class that corresponds to the description (JAXB).
2. Define the method that converts the developed XML document to another document, using xsl-conversion.



 Task Computers
Computer components have the following characteristics:
	Name - the name of the component.
	Origin - the country of production.
	Price - price (0 - n rubles).
	Type (should be several) - peripheral or not, power consumption (watt), the presence of a cooler (is there or not), a group of components (input / output devices, multimedia), ports (COM, USB, LPT).
	Critical - whether the availability of components for the computer is critical.
	The root element is called Devices.