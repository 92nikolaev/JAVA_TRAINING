package by.epam.nikolaev.ilya.service.comparator.tour;

import java.util.Comparator;

import by.epam.nikolaev.ilya.bean.Tour;

public class TourTypeComparator implements Comparator<Tour> {

	@Override
	public int compare(Tour tourOne, Tour tourSecond) {
				
		return tourOne.getTypeTour().compareTo(tourSecond.getTypeTour());
	}
	

}
