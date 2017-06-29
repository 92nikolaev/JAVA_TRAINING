package by.epam.nikolaev.ilya.bean.impl.tour;

import by.epam.nikolaev.ilya.bean.Tour;
import by.epam.nikolaev.ilya.service.impl.builder.tour.BuilderSeaTour;

public class SeaTour extends Tour {
	private String hotel;
	private String resort;
	private boolean isTransfert;
	

	public SeaTour(BuilderSeaTour builderSeaTour) {
		super(builderSeaTour.getTypeTour(),
				builderSeaTour.getDepartureDate(),
				builderSeaTour.getVisitedCountries(),
				builderSeaTour.getDuration(),
				builderSeaTour.getMeal(),
				builderSeaTour.getTransport(),
				builderSeaTour.getTourCost());
		this.hotel = builderSeaTour.getHotel();
		this.resort = builderSeaTour.getResort();
		this.isTransfert = builderSeaTour.isTransfert();
	}
	public String getHotel() {
		return hotel;
	}
	public String getResort() {
		return resort;
	}
	public boolean isTransfert() {
		return isTransfert;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public void setResort(String resort) {
		this.resort = resort;
	}
	public void setTransfert(boolean transfert) {
		this.isTransfert = transfert;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + (isTransfert ? 1231 : 1237);
		result = prime * result + ((resort == null) ? 0 : resort.hashCode());
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
		SeaTour other = (SeaTour) obj;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (isTransfert != other.isTransfert)
			return false;
		if (resort == null) {
			if (other.resort != null)
				return false;
		} else if (!resort.equals(other.resort))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SeaTour [hotel=" + hotel + ", resort=" + resort + ", transfert=" + isTransfert + ", toString()="
				+ super.toString() + "]";
	}
}
