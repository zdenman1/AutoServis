package org.example.customer;

import java.util.List;

public interface CustomerRepository {
	List<Customer> getAll();

	void create(Customer customer);
}