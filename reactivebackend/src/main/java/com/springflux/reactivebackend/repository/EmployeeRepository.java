package com.springflux.reactivebackend.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.springflux.reactivebackend.model.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String>{
	
}
