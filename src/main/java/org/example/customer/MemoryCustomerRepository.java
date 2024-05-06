package org.example.customer;

import java.util.ArrayList;

public class MemoryCustomerRepository implements CustomerRepository {
	private ArrayList<Customer> zakaznici;

	public MemoryCustomerRepository() {
		this.zakaznici = new ArrayList<>();
	}

	@Override
	public ArrayList<Customer> getAll() {
		return this.zakaznici;
	}

	@Override
	public void create(Customer customer) {
		this.zakaznici.add(customer);
	}
}