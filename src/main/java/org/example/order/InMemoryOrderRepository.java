package org.example.order;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {

	private final List<Order> orderList;

	public InMemoryOrderRepository() {
		this.orderList = new ArrayList<>();
	}

	@Override
	public List<Order> getAll() {
		return this.orderList;
	}

	@Override
	public void create(Order order) {
		this.orderList.add(order);
	}
}
