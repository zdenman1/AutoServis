package org.example.car;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCarRepository implements CarRepository {
	private final List<Car> carList;

	public InMemoryCarRepository() {
		this.carList = new ArrayList<>();
	}

	@Override
	public List<Car> getAll() {
		return this.carList;
	}

	@Override
	public void create(Car car) {
		this.carList.add(car);
	}
}
