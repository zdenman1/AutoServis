package org.example.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.order.Order;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Invoice {

	private String id;
	private Order order;
	private double amount;
	private String currency;

	public Invoice(String id, Order order, double amount, String currency) {
		this.id = id;
		this.order = order;
		this.amount = amount;
		this.currency = currency;
	}

	public Invoice(Order order, double amount, String currency) {
		this.id = UUID.randomUUID().toString();
		this.order = order;
		this.amount = amount;
		this.currency = currency;
	}
}
