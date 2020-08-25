package com.spring.jpa_join_demo.dto;

import com.spring.jpa_join_demo.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {
	
	private Customer customer;

}
