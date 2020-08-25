package com.ron.business;

import java.util.ArrayList;
import java.util.List;

import com.ron.data.api.TodoService;

public class TodoBusinessImpl {
	
	TodoService todoService;
	
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveSpringTodos(){
		List<String> springTodos = new ArrayList<String>();
		List<String> allTodos = todoService.getAllTodos();
		for(String str: allTodos)
			if(str.contains("Spring"))
				springTodos.add(str);
		return springTodos;
	}
}
