package by.epam.nikolaev.ilya.service;

import java.util.ArrayList;

import by.epam.nikolaev.ilya.bean.Tour;

public interface IVoucherSorter {
	 
	ArrayList<Tour> sortByTourPrice(ArrayList<Tour> tours);
	ArrayList<Tour> sortByTourType(ArrayList<Tour> tours);
	ArrayList<Tour> sortByTourDuration(ArrayList<Tour> tours);
	

}
