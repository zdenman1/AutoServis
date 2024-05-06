package org.example.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Customer {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private List<Car> cars;

	public Customer(String id, String firstName, String lastName, String phone, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.cars = new ArrayList<>();
	}

	public Customer(String firstName, String lastName, String phone, String email) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.cars = new ArrayList<>();
	}

	void addCar(Car car) {
		this.cars.add(car);
	}
}