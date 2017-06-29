package by.epam.nikolaev.ilya.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import by.epam.nikolaev.ilya.bean.RailwayPlatform;
import by.epam.nikolaev.ilya.bean.Train;

public class DispatcherTrainTest {

	@Test
	public void test() throws InterruptedException {
		ArrayList<Train> trains = new ArrayList<>();
		trains.add(new Train("First Moscow-Minsk", 301, true));
		trains.add(new Train("Second Talin-Dublin", 1200, false));
		trains.add(new Train("Third Riga-Minsk", 301, true));
		trains.add(new Train("Fourth Drezdan-Pinsk", 500, false));
		trains.add(new Train("Fifth Warshava-Brest", 1000, true));
		trains.add(new Train("Sixth Chelabinsk-Moskva", 225, true));
		trains.add(new Train("Seventh Homel-Hrodno", 1000, true));
		trains.add(new Train("Eighth Vitebsk-Lida", 500, false));
		trains.add(new Train("Ninth Murmansk-Vladivostok", 1000, true));
		trains.add(new Train("Tenth Udmurtia-Pikin", 500, false));
		ExecutorService service = Executors.newFixedThreadPool(10);
		RailwayPlatform platform = new RailwayPlatform();
		
		for (int i = 0; i < 10; i++) {
			service.submit(new DispatcherTrain(trains.get(i), platform));
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		service.shutdown();
		Thread.sleep(10000);
		assertTrue(service.isShutdown());;
		
	}

}
