package by.epam.nikolaev.ilya.service.comparator.tour;

import java.util.Comparator;

import by.epam.nikolaev.ilya.bean.Tour;

public class TourTypeMealComparator implements Comparator<Tour> {

	@Override
	public int compare(Tour tourFirst, Tour tourSecond) {
		
		
		return tourFirst.getMeal().compareTo(tourSecond.getMeal());
	}

	

}
