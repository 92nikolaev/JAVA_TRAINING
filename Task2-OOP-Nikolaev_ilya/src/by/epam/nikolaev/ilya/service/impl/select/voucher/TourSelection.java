package by.epam.nikolaev.ilya.service.impl.select.voucher;

import java.util.ArrayList;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.bean.type.TypeMeal;
import by.epam.nikolaev.ilya.bean.type.TypeTour;
import by.epam.nikolaev.ilya.service.ITourSelection;
import by.epam.nikolaev.ilya.service.IVoucherSorter;

public class TourSelection implements ITourSelection {
	
	

	@Override
	public ArrayList<Tour> getTourPriseUntil(ArrayList<Tour> list, int price) {
		ArrayList<Tour> selectList = new ArrayList<>();
		for (Tour tour : list) {
			if(tour.getTourCost()<=price){
				selectList.add(tour);				
			}
			IVoucherSorter sortVoucher = VoucherSorter.getInstance();
			sortVoucher.sortByTourPrice(selectList);
		}
		return selectList;
	}

	@Override
	public ArrayList<Tour> getTourPriseUp(ArrayList<Tour> list, int price) {
		ArrayList<Tour> selectList = new ArrayList<>();
		for (Tour tour : list) {
			if(tour.getTourCost()>=price){
				selectList.add(tour);				
			}
			IVoucherSorter sortVoucher = VoucherSorter.getInstance();
			sortVoucher.sortByTourPrice(selectList);
		}
		return selectList;
	}

	@Override
	public ArrayList<Tour> getTourTypeMeal(ArrayList<Tour> list, TypeMeal meal) {
		ArrayList<Tour> selectList = new ArrayList<>();
		for (Tour tour : list) {
			if(tour.getMeal() == meal){
				selectList.add(tour);				
			}
			IVoucherSorter sortVoucher = VoucherSorter.getInstance();
			sortVoucher.sortByTourPrice(selectList);
		}
		return selectList;
	}

	@Override
	public ArrayList<Tour> getTourDurationUntil(ArrayList<Tour> list, int duration) {
		ArrayList<Tour> selectList = new ArrayList<>();
		for (Tour tour : list) {
			if(tour.getDuration()<= duration){
				selectList.add(tour);				
			}
			IVoucherSorter sortVoucher = VoucherSorter.getInstance();
			sortVoucher.sortByTourDuration(selectList);
		}
		return selectList;
	}

	@Override
	public ArrayList<Tour> getTourDurationUp(ArrayList<Tour> list, int duration) {
		ArrayList<Tour> selectList = new ArrayList<>();
		for (Tour tour : list) {
			if(tour.getDuration()>= duration){
				selectList.add(tour);				
			}
			IVoucherSorter sortVoucher = VoucherSorter.getInstance();
			sortVoucher.sortByTourDuration(selectList);
		}
		return selectList;
	}

	@Override
	public ArrayList<Tour> getTourTypeTour(ArrayList<Tour> list, TypeTour typeTour) {
		ArrayList<Tour> selectList = new ArrayList<>();
		for (Tour tour : list) {
			if(tour.getTypeTour()== typeTour){
				selectList.add(tour);				
			}
			IVoucherSorter sortVoucher = VoucherSorter.getInstance();
			sortVoucher.sortByTourPrice(selectList);
		}
		return selectList;
	}
	

}
