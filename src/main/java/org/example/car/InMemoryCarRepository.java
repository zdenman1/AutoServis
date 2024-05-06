package org.example.car;

import java.util.ArrayList;

public class InMemoryCarRepository implements CarRepository {
	private final ArrayList<Car> carList;

	public InMemoryCarRepository() {
		this.carList = new ArrayList<>();
	}

	@Override
	public ArrayList<Car> getAll() {
		return this.carList;
	}

	@Override
	public void create(Car car) {
		this.carList.add(car);
	}
}
