package by.epam.nikolaev.ilya.bean.impl.tour;

import java.time.LocalDate;
import java.util.ArrayList;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.bean.type.TypeMeal;
import by.epam.nikolaev.ilya.bean.type.TypeTour;
import by.epam.nikolaev.ilya.service.impl.builder.tour.BuilderTherapyTour;

public class TherapyTour extends Tour {
	private String typeTherapy;
	private ArrayList<String> includingProcedures;
	
	
	public TherapyTour(TypeTour typeTour, LocalDate departureDate, String visitedCountries, int duration, TypeMeal meal,
			String transport, int tourCost, String typeTherapy, ArrayList<String> includingProcedures) {
		super(typeTour, departureDate, visitedCountries, duration, meal, transport, tourCost);
		this.typeTherapy = typeTherapy;
		this.includingProcedures = includingProcedures;
	}
	


	public TherapyTour(BuilderTherapyTour builderTherapyTour) {
		super(builderTherapyTour.getTypeTour(),
				builderTherapyTour.getDepartureDate(),
				builderTherapyTour.getVisitedCountries(),
				builderTherapyTour.getDuration(),
				builderTherapyTour.getMeal(),
				builderTherapyTour.getTransport(),
				builderTherapyTour.getTourCost());
		this.typeTherapy = builderTherapyTour.getTypeTherapy();
		this.includingProcedures = builderTherapyTour.getIncludingProcedures();
	}



	public String getTypeTherapy() {
		return typeTherapy;
	}



	public ArrayList<String> getIncludingProcedures() {
		return includingProcedures;
	}



	public void setTypeTherapy(String typeTherapy) {
		this.typeTherapy = typeTherapy;
	}



	public void setIncludingProcedures(ArrayList<String> includingProcedures) {
		this.includingProcedures = includingProcedures;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((includingProcedures == null) ? 0 : includingProcedures.hashCode());
		result = prime * result + ((typeTherapy == null) ? 0 : typeTherapy.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TherapyTour other = (TherapyTour) obj;
		if (includingProcedures == null) {
			if (other.includingProcedures != null)
				return false;
		} else if (!includingProcedures.equals(other.includingProcedures))
			return false;
		if (typeTherapy == null) {
			if (other.typeTherapy != null)
				return false;
		} else if (!typeTherapy.equals(other.typeTherapy))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TherapyTour [typeTherapy=" + typeTherapy + ", includingProcedures=" + includingProcedures
				+ ", toString()=" + super.toString() + "]";
	}
	
}
