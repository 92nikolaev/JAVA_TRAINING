package by.epam.nikolaev.ilya.service.comparator.tour;

import java.util.Comparator;

import by.epam.nikolaev.ilya.bean.Tour;

public class TourCostComparator implements Comparator<Tour>{

	@Override
	public int compare(Tour tourCostFirst, Tour tourCostSecond) {
		Double first =  new Double(tourCostFirst.getTourCost());
		Double second = new Double(tourCostSecond.getTourCost());
		return first.compareTo(second);
	}

}
