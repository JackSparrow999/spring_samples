package com.ron.business;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ron.data.api.TodoService;
import com.ron.data.api.TodoServiceStub;

public class TestTodoBusinessImpl {

	TodoService todoService;
	TodoBusinessImpl todoBusinessImpl;
	
	@Test
	public void test() {
		todoService = new TodoServiceStub();
		todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		for(String str: todoBusinessImpl.retrieveSpringTodos())
			assertTrue(str.contains("Spring"));
	}

}
