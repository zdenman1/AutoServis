package org.example.customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository implements CustomerRepository {

	private final List<Customer> customerList;

	public InMemoryCustomerRepository() {
		this.customerList = new ArrayList<>();
	}

	@Override
	public List<Customer> getAll() {
		return this.customerList;
	}

	@Override
	public void create(Customer customer) {
		this.customerList.add(customer);
	}
}