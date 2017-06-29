package by.epam.nikolaev.ilya.service.impl.select.voucher;

import java.util.ArrayList;
import java.util.Collections;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.service.IVoucherSorter;
import by.epam.nikolaev.ilya.service.comparator.tour.TourCostComparator;
import by.epam.nikolaev.ilya.service.comparator.tour.TourTypeComparator;

public class VoucherSorter implements IVoucherSorter {
	
	private static VoucherSorter instance;
	private VoucherSorter() {}
	
	public static VoucherSorter getInstance(){
		return (instance == null)?new VoucherSorter(): instance;
	}

	@Override
	public ArrayList<Tour> sortByTourPrice(ArrayList<Tour> tours) {
		Collections.sort(tours, new TourCostComparator());
		return tours;
	}

	@Override
	public ArrayList<Tour> sortByTourType(ArrayList<Tour> tours) {
		Collections.sort(tours, new TourTypeComparator());
		return tours;
	}

	@Override
	public ArrayList<Tour> sortByTourDuration(ArrayList<Tour> tours) {
		Collections.sort(tours, new TourCostComparator());
		return tours;
	}

}
