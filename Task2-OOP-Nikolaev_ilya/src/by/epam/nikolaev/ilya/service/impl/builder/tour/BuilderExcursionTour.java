package by.epam.nikolaev.ilya.service.impl.builder.tour;

import java.util.ArrayList;
import by.epam.nikolaev.ilya.bean.impl.tour.ExcursionTour;
import by.epam.nikolaev.ilya.service.BuilderTour;

public class BuilderExcursionTour extends BuilderTour {
	
	private ArrayList<String> cities;

	public BuilderExcursionTour setVisitCity(ArrayList<String> cities){
		this.cities = cities;
		return this;
	}
	
	public ArrayList<String> getCities() {
		return cities;
	}
	@Override
	public ExcursionTour build(){
		return new ExcursionTour(this);
	}
	
	

}
