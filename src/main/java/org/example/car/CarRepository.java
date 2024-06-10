package org.example.car;


import java.util.List;

public interface CarRepository {
	List<Car> getAll();

	void create(Car car);
}
