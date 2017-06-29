package by.epam.nikolaev.ilya.service.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.nikolaev.ilya.bean.Text;
import by.epam.nikolaev.ilya.service.Task;

public class TestConvertWordFirstSymbol {

	static final Map<String,String> testData = new HashMap<>();
	
	@BeforeClass
		public static void init(){
			testData.put(NameParameter.CONVERT_WORD_FIRST_SYMBOL_FIRST_TEST_EXPECTED, NameParameter.CONVERT_WORD_FIRST_SYMBOL_FIRST_TEST);
			
		}

	@Test
	public void testConvertWordFirstSymbol() {
		for(Map.Entry<String, String> entry: testData.entrySet()){
			String expected = entry.getKey();
			Text text = new Text(entry.getValue());
			text = Task.convertWordFirstSymbol(text);
			String actual = text.toString().trim();
			Assert.assertEquals(expected, actual);
			
		}
	}

}
