package com.ron.business;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.ron.data.api.TodoService;

public class TestTodoBusinessImplMock {
	
	TodoService todoServiceMock;
	TodoBusinessImpl todoBusinessImpl;
	
	@Test
	public void test() {
		todoServiceMock = mock(TodoService.class);
		todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		when(todoServiceMock.getAllTodos()).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring Boot", "Learn Rust"));
		
		for(String str: todoBusinessImpl.retrieveSpringTodos())
			assertTrue(str.contains("Spring"));
	}
	
}
