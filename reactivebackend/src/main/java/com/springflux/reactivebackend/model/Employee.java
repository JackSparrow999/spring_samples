package com.springflux.reactivebackend.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table("employees")
public class Employee {
	
	String id;
	String name;
	long sal;
	
}
