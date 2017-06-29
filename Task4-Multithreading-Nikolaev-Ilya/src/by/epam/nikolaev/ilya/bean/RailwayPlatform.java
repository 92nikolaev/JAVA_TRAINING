package by.epam.nikolaev.ilya.bean;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RailwayPlatform {
	/**
	 * ������ �������� �� ��� ������� �� ���������
	 */
	private final ArrayList<Track> tracks = new ArrayList<>(2);
	/**
	 * ����� ����� ���������� ������ �� ��������� ���� �� ����� ��� �� �������
	 */
	private volatile int timeWaitFirstTrain;
	private volatile int timeWaitSecondTrain;
	/**
	 * Semaphor �� ������� � ���� ������ ����� ���������� �� ����� 2 �������
	 */
	private Semaphore SEMAPHORE = new Semaphore(2, true);
	public RailwayPlatform() {
		tracks.add(new Track(1));
		tracks.add(new Track(2));
	}
	Lock lock = new ReentrantLock();
	
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	
	public Semaphore getSEMAPHORE() {
		return SEMAPHORE;
	}
	
	public void setSEMAPHORE(Semaphore sEMAPHORE) {
		SEMAPHORE = sEMAPHORE;
	}
	public int getTimeWaitFirstTrain() {
		return timeWaitFirstTrain;
	}
	public int getTimeWaitSecondTrain() {
		return timeWaitSecondTrain;
	}
	public void setTimeWaitFirstTrain(int timeWaitFirstTrain) {
		this.timeWaitFirstTrain = timeWaitFirstTrain;
	}
	public void setTimeWaitSecondTrain(int timeWaitSecondTrain) {
		this.timeWaitSecondTrain = timeWaitSecondTrain;
	}
}
