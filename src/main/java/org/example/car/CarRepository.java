package org.example.car;


import java.util.ArrayList;

public interface CarRepository {

	ArrayList<Car> getAll();

	void create(Car car);

}
