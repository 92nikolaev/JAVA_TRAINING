package by.epam.nikolaev.ilya.service.impl.builder.tour;


import by.epam.nikolaev.ilya.bean.impl.tour.SeaTour;
import by.epam.nikolaev.ilya.service.BuilderTour;

public class BuilderSeaTour extends BuilderTour{
	private String hotel;
	private String resort;
	private boolean transfert;
	
	public BuilderSeaTour setHotel(String hotel){
		this.hotel = hotel;
		return this;
	}
	public BuilderSeaTour setResort(String resort){
		this.resort = resort;
		return this;
	}
	
	
	public BuilderSeaTour setTransfert(boolean transfert){
		this.transfert = transfert;
		return this;
	}
	

	public String getHotel() {
		return hotel;
	}

	public String getResort() {
		return resort;
	}

	public boolean isTransfert() {
		return transfert;
	}

	@Override
	public SeaTour build() {
		return new SeaTour(this);
	}
	
	
}
