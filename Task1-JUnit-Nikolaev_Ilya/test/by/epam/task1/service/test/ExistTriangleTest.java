
package by.epam.task1.service.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.junit.runners.Parameterized.Parameters;

import by.epam.task1.bean.Point;
import by.epam.task1.helper.Helper;
import by.epam.task1.helper.NameParameter;
import by.epam.task1.service.ValidationTriangle;


/**
 * @author Nikolaev Ilya
 *
 */
@RunWith(Parameterized.class)
public class ExistTriangleTest {
	@Parameterized.Parameter
	public JSONObject json;
	@Parameters
	public static Collection<Object[]> data() throws FileNotFoundException, IOException, ParseException{
		return Helper.loadingTestData(NameParameter.FILE_1);
	}

		@Test
		public void testIsExistTriangle() {
			double PointACordX = Double.parseDouble((String) json.get(NameParameter.POINT_A_CORD_X));
			double PointACordY = Double.parseDouble((String) json.get(NameParameter.POINT_A_CORD_Y));
			double PointBCordX = Double.parseDouble((String) json.get(NameParameter.POINT_B_CORD_X));
			double PointBCordY = Double.parseDouble((String) json.get(NameParameter.POINT_B_CORD_Y));
			double PointCCordX = Double.parseDouble((String) json.get(NameParameter.POINT_C_CORD_X));
			double PointCCordY = Double.parseDouble((String) json.get(NameParameter.POINT_C_CORD_Y));
			Point a = new Point(PointACordX,PointACordY);
			Point b = new Point(PointBCordX, PointBCordY);
			Point c = new Point(PointCCordX, PointCCordY);
			boolean isExist =  (boolean) json.get(NameParameter.IS_EXIST);
			ValidationTriangle checkTriangle = ValidationTriangle.getInstance();
			boolean result = checkTriangle.isExistTriangle(a, b, c); 
			assertEquals(isExist, result);	
		}
		

}
