package org.example.car;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Car {

	private String id;
	private String brand;
	private String model;
	private int year;
	private String registrationNumber;
	private String vin;
	private String issue;
	private List<Customer> customers;

	public Car(String id, String brand, String model, int year, String registrationNumber, String vin, String issue) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.registrationNumber = registrationNumber;
		this.vin = vin;
		this.issue = issue;
		this.customers = new ArrayList<>(); // Inicializace seznamu zákazníků
	}

	public Car(String brand, String model, int year, String registrationNumber, String vin, String issue) {
		this.id = UUID.randomUUID().toString();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.registrationNumber = registrationNumber;
		this.vin = vin;
		this.issue = issue;
		this.customers = new ArrayList<>();
	}

	void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
}
