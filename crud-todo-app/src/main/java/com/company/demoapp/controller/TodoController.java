package com.company.demoapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.demoapp.dao.TodoRepository;
import com.company.demoapp.model.Todo;
import com.company.demoapp.service.TodoService;

@RestController
@RequestMapping("/todo/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private TodoRepository todoRepository;
	private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

	@GetMapping("/test")
	public String test() {
		LOG.info("----- SERVER WORKING -----");
		return "<h1>Server is Running</h1>";
	}

	@PostMapping("/todo")
	public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
		LOG.info("----- ADD TODO WORKING -----");
		Todo newTodo = todoService.addTodo(todo);
		return (newTodo == null) ? (ResponseEntity<?>) ResponseEntity.internalServerError()
				: ResponseEntity.ok(newTodo);
	}

	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> fetchAllTodos() {
		LOG.info("----- GET TODO WORKING -----");
		List<Todo> todos = todoService.getAllTodos();
		return ResponseEntity.ok(todos);
	}

	@PutMapping("/todo/{title}")
	public ResponseEntity<?> updateTodo(@PathVariable String title) {
		LOG.info("----- UPDATE TODO WORKING -----");
		Todo todo = todoService.updateTodoByTitle(title);
		return (todo == null) ? (ResponseEntity<?>) ResponseEntity.internalServerError() : ResponseEntity.ok(todo);
	}

	@DeleteMapping("/todo/{title}")
	public ResponseEntity<?> deleteTodo(@PathVariable String title) {
		LOG.info("----- DEL TODO WORKING -----");
		boolean deleteStatus = todoService.deleteTodoByTitle(title);
		return (deleteStatus) ? ResponseEntity.ok("Todo Deleted")
				: (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

//	@DeleteMapping("/todo/{title}")
//	public String deleteTodo(@PathVariable String title) {
//		LOG.info("----- DEL TODO WORKING -----");
//		boolean deleteStatus = todoService.deleteTodoByTitle(title);
//		return (deleteStatus) ? "Todo Deleted" : "Todo Not Found";
//	}

	@DeleteMapping("/todos")
	public String deleteAllTodos() {
		boolean status = todoRepository.findAll().isEmpty();
		if (status != true)
			todoRepository.deleteAll();
		return (status) ? "No Todo Exists" : "All Todo Deleted";
	}

}
