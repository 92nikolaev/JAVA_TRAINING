package by.epam.nikolaev.ilya.service;

public class Main {

	public static void main(String[] args) {
		String nameFile = "XML/devise.xml";
		String schemaName = "XML/devices.xsd";
		
		System.out.println(ValidatorXML.validationXML(nameFile, schemaName));
		
		
		}

}

