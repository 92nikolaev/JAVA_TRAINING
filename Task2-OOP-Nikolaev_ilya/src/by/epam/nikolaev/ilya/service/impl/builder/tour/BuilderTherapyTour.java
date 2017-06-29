package by.epam.nikolaev.ilya.service.impl.builder.tour;

import java.util.ArrayList;

import by.epam.nikolaev.ilya.bean.impl.tour.TherapyTour;
import by.epam.nikolaev.ilya.service.BuilderTour;

public class BuilderTherapyTour extends BuilderTour {
	private String typeTherapy;
	private ArrayList<String> includingProcedures;
	
	
	public String getTypeTherapy() {
		return typeTherapy;
	}
	public ArrayList<String> getIncludingProcedures() {
		return includingProcedures;
	}
	
	
	public BuilderTherapyTour setTypeTherapy(String typeTherapy){
		this.typeTherapy = typeTherapy;
		return this;
	}
	public BuilderTherapyTour setIncludingProcedures(ArrayList<String> includingProcedures){
		this.includingProcedures = includingProcedures;
		return this;
	}
		




	@Override
	public TherapyTour build() {
		return new TherapyTour(this);
	}

}
