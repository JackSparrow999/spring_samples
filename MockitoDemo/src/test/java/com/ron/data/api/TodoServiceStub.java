package com.ron.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{

	public List<String> getAllTodos() {
		return Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Rust");
	}
	
}
