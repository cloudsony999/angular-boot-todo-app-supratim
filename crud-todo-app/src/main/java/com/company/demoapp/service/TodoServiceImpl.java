package com.company.demoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.demoapp.dao.TodoRepository;
import com.company.demoapp.model.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Todo addTodo(Todo todo) {
		Todo checkTodo = todoRepository.findById(todo.getTitle()).orElse(null);
		return (checkTodo == null) ? todoRepository.save(todo) : null;
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Todo updateTodoByTitle(String title) {
		Todo checkTodo = todoRepository.findById(title).orElse(null);
		if (checkTodo != null) {
			boolean activeStatus = (checkTodo.getActive()) ? false : true;
			checkTodo.setActive(activeStatus);
			return todoRepository.save(checkTodo);
		}
		return null;
	}

	@Override
	public boolean deleteTodoByTitle(String title) {
		Todo todo = todoRepository.findById(title).orElse(null);
		if (todo != null) {
			todoRepository.deleteById(title);
			return true;
		}
		return false;
	}

}
