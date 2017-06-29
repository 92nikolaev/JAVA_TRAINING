package by.epam.nikolaev.ilya.service;

import java.time.LocalDate;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.bean.type.TypeMeal;
import by.epam.nikolaev.ilya.bean.type.TypeTour;


public abstract class BuilderTour {
	private TypeTour typeTour;
	private LocalDate departureDate;
	private String visitedCountries;
	private int duration; //prodoljitil'nost'
	private TypeMeal meal;
	private String transport;
	private int tourCost;
	
	
	public BuilderTour setTypeTour(TypeTour typeTour){
		this.typeTour = typeTour;
		return this;
	}
	public BuilderTour setDepartureDate(LocalDate departureDate){
		this.departureDate = departureDate;
		return this;
	}
	public BuilderTour setVisitedCountries(String visitedCountries){
		this.visitedCountries = visitedCountries;
		return this;
	}
	public BuilderTour setMeal(TypeMeal meal){
		this.meal = meal;
		return this;
	}
	public BuilderTour setDuration(int duration){
		this.duration = duration;
		return this;
	}
	
	public BuilderTour setTransport(String transport){
		this.transport = transport;
		return this;
	}
	public BuilderTour setTourCost(int tourCost){
		this.tourCost = tourCost;
		return this;
	}
	public TypeTour getTypeTour() {
		return typeTour;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public String getVisitedCountries() {
		return visitedCountries;
	}
	public int getDuration() {
		return duration;
	}
	public TypeMeal getMeal() {
		return meal;
	}
	public String getTransport() {
		return transport;
	}
	public int getTourCost() {
		return tourCost;
	}
	
	public abstract Tour build();
	
}
