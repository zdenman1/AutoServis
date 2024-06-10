package org.example.car;

import java.util.List;

public class CarService {

	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void create(CarCreateParams params) {

		Car car = new Car(
				params.brand(),
				params.model(),
				params.year(),
				params.registrationNumber(),
				params.vin(),
				null
		);

		this.carRepository.create(car);
	}

	public List<Car> getAll() {
		return this.carRepository.getAll();
	}
}
