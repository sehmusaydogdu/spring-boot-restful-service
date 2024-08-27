package com.ms.restful.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.ms.restful.dto.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerService implements ICustomerService {

	// in memory data
	private static final List<Customer> customerDBList = new ArrayList<>();

	static {
		customerDBList.add(new Customer(1L, "12345678901", "Ali", "Kaya", LocalDateTime.now()));
		customerDBList.add(new Customer(2L, "12345678901", "Ayşe", "Yücel", LocalDateTime.now()));
	}

	@Override
	public List<Customer> fetchAll() {
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
		if (data.isEmpty()) {
			throw new IllegalArgumentException("Data Not Found.");
		}
		customerDBList.removeIf(item -> Objects.equals(item.getCustomerId(), customerId));
		Customer model = new Customer();
		model.setBirthday(newCustomer.getBirthday());
		model.setTckn(newCustomer.getTckn());
		model.setName(newCustomer.getName());
		model.setSurname(newCustomer.getSurname());
		customerDBList.add(model);
	}
}
