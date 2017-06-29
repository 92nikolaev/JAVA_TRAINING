package by.epam.nikolaev.ilya.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.service.impl.reader.tour.TourReaderJSON;

public class TestGetterAllTour {

	@Test
	public void testAll() {
		ITourGetter tourGetter = TourReaderJSON.getInstance();
		ArrayList<Tour> list = (ArrayList<Tour>) tourGetter.getAllTour();
		int expected = 40;
		int actual = list.size(); 
		assertEquals(expected, actual);
	}
	
	

}
