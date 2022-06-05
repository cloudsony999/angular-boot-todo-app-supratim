package com.company.demoapp.service;

import java.util.List;

import com.company.demoapp.model.Todo;

public interface TodoService {

	public Todo addTodo(Todo todo); // C

	public List<Todo> getAllTodos(); // R

	public Todo updateTodoByTitle(String title); // U

	public boolean deleteTodoByTitle(String title); // D

}
