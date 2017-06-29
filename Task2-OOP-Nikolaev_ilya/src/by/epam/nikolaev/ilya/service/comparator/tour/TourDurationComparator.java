package by.epam.nikolaev.ilya.service.comparator.tour;

import java.util.Comparator;

import by.epam.nikolaev.ilya.bean.Tour;

public class TourDurationComparator implements Comparator<Tour> {

	@Override
	public int compare(Tour durationFirst, Tour durationSecond) {
		Integer first = new Integer(durationFirst.getDuration());
		Integer second = new Integer(durationSecond.getDuration());
		return first.compareTo(second);
	}
	

}
