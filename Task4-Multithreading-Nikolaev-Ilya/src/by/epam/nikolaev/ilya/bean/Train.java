package by.epam.nikolaev.ilya.bean;

public class Train {
	private String Name;  // ������� ������
	private volatile int timeStop; // ����� ���������
	private boolean isHuman; // � ���������� ���� ���
	
	public Train(String name, int timeStop, boolean isHuman) {
		super();
		Name = name;
		this.timeStop = timeStop;
		this.isHuman = isHuman;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	public int getTimeStop() {
		return timeStop;
	}

	public void setTimeStop(int timeStop) {
		this.timeStop = timeStop;
	}
}
