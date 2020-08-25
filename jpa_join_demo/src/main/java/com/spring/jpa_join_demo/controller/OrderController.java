package com.spring.jpa_join_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa_join_demo.dto.JoinDto;
import com.spring.jpa_join_demo.dto.OrderDto;
import com.spring.jpa_join_demo.model.Customer;
import com.spring.jpa_join_demo.repository.CustomerRepository;

@RestController
public class OrderController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/order")
	public Customer placeOrder(@RequestBody OrderDto order) {
		return customerRepository.save(order.getCustomer());
	}
	
	@GetMapping("/customers")
	public List<Customer> findCustomers(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/order_info")
	public List<JoinDto> findCustomersAndProducts(){
		return customerRepository.getCustomerAndProductName();
	}
}
