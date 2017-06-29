package by.epam.nikolaev.ilya.bean.impl.tour;
import java.util.ArrayList;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.service.impl.builder.tour.BuilderExcursionTour;

public class ExcursionTour extends Tour{
	
	private ArrayList<String> cities;
	public ExcursionTour(BuilderExcursionTour buildExcursionTour) {
		super(buildExcursionTour.getTypeTour(),
				buildExcursionTour.getDepartureDate(),
				buildExcursionTour.getVisitedCountries(),
				buildExcursionTour.getDuration(),
				buildExcursionTour.getMeal(),
				buildExcursionTour.getTransport(),
				buildExcursionTour.getTourCost());
		this.cities = buildExcursionTour.getCities();
	}
	public ArrayList<String> getCities() {
		return cities;
	}
	public void setCities(ArrayList<String> cities) {
		this.cities = cities;
	}
	@Override
	public String toString() {
		return "ExcursionTour [cities=" + cities + ", toString()=" + super.toString() + "]";
	}	
}
