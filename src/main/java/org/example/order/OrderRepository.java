package org.example.order;

import java.util.List;

public interface OrderRepository {
	List<Order> getAll();

	void create(Order order);
}
