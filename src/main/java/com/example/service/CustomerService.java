package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.model.Customer;

public class CustomerService implements ICustomerService {
	
	@Override
	public List<Customer> fetchAll() {
		return new ArrayList<>();
	}

	@Override
	public Optional<Customer> fetch(Long customerId) {
		return Optional.empty();
	}

	@Override
	public void insert(Customer customer) {

	}

	@Override
	public void delete(Long customerId) {

	}

	@Override
	public void update(Long customerId, Customer newCustomer) {
	
	}
}
