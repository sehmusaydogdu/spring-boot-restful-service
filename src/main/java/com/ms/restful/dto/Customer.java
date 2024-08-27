package com.ms.restful.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Long customerId;
	private String tckn;
	private String name;
	private String surname;
	private LocalDateTime birthday;
}
