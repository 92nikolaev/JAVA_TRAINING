package by.epam.nikolaev.ilya.service;

import java.util.ArrayList;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.bean.type.TypeMeal;
import by.epam.nikolaev.ilya.bean.type.TypeTour;

public interface ITourSelection {
	
	ArrayList<Tour> getTourPriseUntil(ArrayList<Tour> list, int price);
	ArrayList<Tour> getTourPriseUp(ArrayList<Tour> list, int price);
	ArrayList<Tour> getTourTypeMeal(ArrayList<Tour> list, TypeMeal meal);
	ArrayList<Tour> getTourDurationUntil(ArrayList<Tour> list, int duration);
	ArrayList<Tour> getTourDurationUp(ArrayList<Tour> list, int duration);
	ArrayList<Tour> getTourTypeTour(ArrayList<Tour> list, TypeTour typeTour);
}
