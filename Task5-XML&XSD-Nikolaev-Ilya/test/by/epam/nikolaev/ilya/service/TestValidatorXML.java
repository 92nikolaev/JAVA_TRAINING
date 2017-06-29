package by.epam.nikolaev.ilya.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestValidatorXML {

	@Test
	public void test() {
		String nameFile = "XML/devise.xml";
		String schemaName = "XML/devices.xsd";
		assertTrue(ValidatorXML.validationXML(nameFile, schemaName));
	}

}
