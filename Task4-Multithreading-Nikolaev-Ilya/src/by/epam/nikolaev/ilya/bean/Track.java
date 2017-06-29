package by.epam.nikolaev.ilya.bean;

public class Track {
	/**
	 * Есть ли на пути поезд
	 */
	private boolean isEmpty;
	/**
	 * номер пути
	 */
	private int numberTrack;
	
	public Track(int numberTrack) {
		super();
		this.numberTrack = numberTrack;
	}

	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public int getNumberTrack() {
		return numberTrack;
	}
	public void setNumberTrack(int numberTrack) {
		this.numberTrack = numberTrack;
	}
}
