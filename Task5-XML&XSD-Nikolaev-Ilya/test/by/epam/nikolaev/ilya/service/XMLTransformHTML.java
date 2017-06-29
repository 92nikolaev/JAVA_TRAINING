package by.epam.nikolaev.ilya.service;

import static org.junit.Assert.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;

public class XMLTransformHTML {


	@Test
	public void test() {
		boolean result = true;
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource("xml/deviceXSL.xsl"));
			transformer.transform(new StreamSource("xml/devise.xml"), new StreamResult("html/result.html"));
		} catch (TransformerException exeption) {
			result = false;
		}
		assertTrue(result);

	}

}
