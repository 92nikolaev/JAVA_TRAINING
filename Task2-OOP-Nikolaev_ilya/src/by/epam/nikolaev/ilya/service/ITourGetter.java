package by.epam.nikolaev.ilya.service;

import java.util.List;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.bean.impl.tour.ExcursionRestTour;
import by.epam.nikolaev.ilya.bean.impl.tour.ExcursionTour;
import by.epam.nikolaev.ilya.bean.impl.tour.SeaTour;
import by.epam.nikolaev.ilya.bean.impl.tour.TherapyTour;

public interface ITourGetter {
	
	List<ExcursionTour> getExcursionTour();
	List<ExcursionRestTour> getExcursionRestTour();
	List<SeaTour> getSeaTour();
	List<TherapyTour> getTherapyTour();
	List<Tour> getAllTour();
}
