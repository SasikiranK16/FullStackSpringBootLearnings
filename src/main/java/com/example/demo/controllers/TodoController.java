package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	@PostMapping("/api/todo/create")
	public ResponseEntity<TodoDTO>createtoDo(@RequestBody TodoDTO todoDTO){
		return new ResponseEntity<TodoDTO>(todoService.createTodo(todoDTO),HttpStatus.CREATED);
	}
	@GetMapping("/api/todos")
	public ResponseEntity<List<Todo>>getdetails(){
		return new ResponseEntity<List<Todo>>(todoService.getAllTodos(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/api/todos/{id}")
	public ResponseEntity<TodoDTO>getdetailsById(@PathVariable("id") long id){
		return new ResponseEntity<TodoDTO>(todoService.getTodosById(id),HttpStatus.ACCEPTED);
	}
	@PutMapping("/api/todos/update/{id}")
	public ResponseEntity<TodoDTO>updateDetails(@PathVariable("id")long id,@RequestBody TodoDTO todoDTO){
		return new ResponseEntity<TodoDTO>(todoService.updateTodoById(id, todoDTO),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/api/todos/delete/{id}")
	public ResponseEntity<String>deleteById(@PathVariable("id")long id){
		todoService.deleteById(id);
		return new ResponseEntity<String>("Successfully Deleted!!",HttpStatus.ACCEPTED);
	}
	@PatchMapping("/api/todos/{id}/completed")
	public ResponseEntity<TodoDTO>iscompleted(@PathVariable("id")long id){
		return new ResponseEntity<TodoDTO>(todoService.isWorkCompleted(id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/api/todos/{id}/notcompleted")
	public ResponseEntity<TodoDTO>notCompleted(@PathVariable("id")long id){
		return new ResponseEntity<TodoDTO>(todoService.notWorkCompleted(id),HttpStatus.OK);
	}
}
