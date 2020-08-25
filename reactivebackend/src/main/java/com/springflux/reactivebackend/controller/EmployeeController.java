package com.springflux.reactivebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springflux.reactivebackend.dto.GenericOutput;
import com.springflux.reactivebackend.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/react")
public class EmployeeController {

	@GetMapping(value = "/employees")
	public Flux<GenericOutput<Employee>> getAllEmployees(){
		return Flux.just(new GenericOutput<Employee>(
							new Employee("1", "ronaq", 65481)),
				new GenericOutput<Employee>(
						new Employee("2", "sushree", 648945)));
	}
	
	@GetMapping(value = "/employee/{id}")
	public Mono<GenericOutput<Employee>> getEmployeebyId(
			@PathVariable("id") String ID){
		return Mono.just(new GenericOutput<Employee>(
				new Employee("3", "Papa", 886468)));
	}
	
	@PostMapping(value = "/employee")
	public Mono<GenericOutput<Employee>> saveEmployee(@RequestBody Employee e){
		return Mono.just(new GenericOutput<Employee>(e));
	} 
	
}
