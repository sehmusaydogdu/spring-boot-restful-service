package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(service.fetchAll());
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.fetch(id));
	}

	@PostMapping("/insert")
	public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
		service.insert(customer);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		service.update(id, customer);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}




