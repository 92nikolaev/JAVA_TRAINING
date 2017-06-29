package by.epam.nikolaev.ilya.bean;

import java.time.LocalDate;

import by.epam.nikolaev.ilya.bean.type.TypeMeal;
import by.epam.nikolaev.ilya.bean.type.TypeTour;
public abstract class Tour {
	
	private TypeTour typeTour;
	private LocalDate departureDate;
	private String visitedCountries;
	private int duration; //prodoljitil'nost'
	private TypeMeal meal;
	private String transport;
	private int tourCost;
	
	public Tour(TypeTour typeTour, LocalDate date, String visitedCountries, int duration, TypeMeal meal, String transport,
			int tourCost) {
		super();
		this.typeTour = typeTour;
		this.departureDate = date;
		this.visitedCountries = visitedCountries;
		this.duration = duration;
		this.meal = meal;
		this.transport = transport;
		this.tourCost = tourCost;
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
	public double getTourCost() {
		return tourCost;
	}
	public void setTypeTour(TypeTour typeTour) {
		this.typeTour = typeTour;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public void setVisitedCountries(String visitedCountries) {
		this.visitedCountries = visitedCountries;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setMeal(TypeMeal meal) {
		this.meal = meal;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public void setTourCost(int tourCost) {
		this.tourCost = tourCost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + duration;
		result = prime * result + ((meal == null) ? 0 : meal.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tourCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transport == null) ? 0 : transport.hashCode());
		result = prime * result + ((typeTour == null) ? 0 : typeTour.hashCode());
		result = prime * result + ((visitedCountries == null) ? 0 : visitedCountries.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (duration != other.duration)
			return false;
		if (meal != other.meal)
			return false;
		if (Double.doubleToLongBits(tourCost) != Double.doubleToLongBits(other.tourCost))
			return false;
		if (transport == null) {
			if (other.transport != null)
				return false;
		} else if (!transport.equals(other.transport))
			return false;
		if (typeTour == null) {
			if (other.typeTour != null)
				return false;
		} else if (!typeTour.equals(other.typeTour))
			return false;
		if (visitedCountries == null) {
			if (other.visitedCountries != null)
				return false;
		} else if (!visitedCountries.equals(other.visitedCountries))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tour [typeTour=" + typeTour + ", departureDate=" + departureDate + ", visitedCountries="
				+ visitedCountries + ", duration=" + duration + ", meal=" + meal + ", transport=" + transport
				+ ", tourCost=" + tourCost + "]";
	}
}


