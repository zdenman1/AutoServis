package org.example.customer;

import java.util.ArrayList;

public interface CustomerRepository {

	ArrayList<Customer> getAll();

	void create(Customer customer);
}