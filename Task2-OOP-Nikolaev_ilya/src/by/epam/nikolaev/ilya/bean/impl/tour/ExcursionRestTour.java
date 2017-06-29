package by.epam.nikolaev.ilya.bean.impl.tour;

import by.epam.nikolaev.ilya.service.impl.builder.tour.BuilderExcursionTour;

public class ExcursionRestTour extends ExcursionTour {

	private String resort;
	private String hotel;
	
	public ExcursionRestTour(BuilderExcursionTour buildExcursionTour) {
		super(buildExcursionTour);
		
		
	}

	@Override
	public String toString() {
		return "ExcursionRestTour [resort=" + resort + ", hotel=" + hotel + ", toString()=" + super.toString() + "]";
	}
	

}
