package com.example.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Long customerId;
	private String tckn;
	private String name;
	private String surname;
	private Date birthday;
}
