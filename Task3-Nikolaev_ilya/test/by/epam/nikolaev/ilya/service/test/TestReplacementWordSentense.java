package by.epam.nikolaev.ilya.service.test;


import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.nikolaev.ilya.bean.Text;
import by.epam.nikolaev.ilya.service.Task;

public class TestReplacementWordSentense {

	static final Map<String,String> testData = new HashMap<>();
	
	
	
	@BeforeClass
	public static void init(){
		testData.put(NameParameter.FIRST_TEST_EXPECTED, NameParameter.FIRST_TEST);
		testData.put(NameParameter.SECOND_TEST_EXPECTED, NameParameter.SECOND_TEST);
	}
	

	@Test
	public void testGetAlltext() {
		for(Map.Entry<String, String> entry: testData.entrySet()){
			String expected = entry.getKey();
			Text text = new Text(entry.getValue());
			text = Task.replacementWordSentense(text, 2, 3,NameParameter.FIRST_TEST_REPLACEMENT);
			String actual = text.toString();
			Assert.assertEquals(expected, actual);
		}
		
	}

}
