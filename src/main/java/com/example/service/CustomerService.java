package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.model.Customer;

public class CustomerService implements ICustomerService {

	// in memory data
	private List<Customer> customerDBList = new ArrayList<>();

	@Override
	public List<Customer> fetchAll() {
		customerDBList.add(new Customer(1L, "12345678901", "Ali", "Kaya", new Date()));
		customerDBList.add(new Customer(2L, "12345678901", "Ayşe", "Yücel", new Date()));
		return customerDBList;
	}

	@Override
	public Optional<Customer> fetch(Long customerId) {
		return customerDBList.stream().filter(item -> Objects.equals(item.getCustomerId(), customerId)).findAny();
	}

	@Override
	public void insert(Customer customer) {
		customerDBList.add(customer);
	}

	@Override
	public void delete(Long customerId) {
		customerDBList.removeIf(item -> Objects.equals(item.getCustomerId(), customerId));
	}

	@Override
	public void update(Long customerId, Customer newCustomer) {
		Optional<Customer> data = customerDBList.stream().filter(item -> Objects.equals(item.getCustomerId(), customerId)).findAny();
		if (!data.isPresent()) {
			throw new IllegalArgumentException("Data Bulunamadı");
		}
		customerDBList.removeIf(item -> Objects.equals(item.getCustomerId(), customerId));
		Customer model = newCustomer;
		model.setCustomerId(customerId);
		customerDBList.add(model);
	}
}
