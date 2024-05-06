package org.example.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.car.Car;
import org.example.customer.Customer;
import org.example.mechanic.Mechanic;

@Getter
@Setter
@ToString
public class Order {

	private String id;
	private Customer customer;
	private Mechanic mechanic;
	private Car car;
	private String description;
	private OrderStatus status;

	public Order(String id, Customer customer, Mechanic mechanic, Car car, String description, OrderStatus status) {
		this.id = id;
		this.customer = customer;
		this.mechanic = mechanic;
		this.car = car;
		this.description = description;
		this.status = status;
	}
}
