package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Customer;

public interface ICustomerService {
	
	List<Customer> fetchAll();
	
	Optional<Customer> fetch(Long customerId);
	
	void insert(Customer customer);

	void delete(Long customerId);
	
	void update(Long customerId, Customer newCustomer);
}
