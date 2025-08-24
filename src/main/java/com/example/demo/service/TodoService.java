package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.TodoDTO;
import com.example.demo.entity.Todo;

public interface TodoService {

	TodoDTO createTodo(TodoDTO todoDTO);
	List<Todo>getAllTodos();
	TodoDTO getTodosById(long id);
	TodoDTO updateTodoById(long id,TodoDTO dto);
	void deleteById(long id);
	TodoDTO isWorkCompleted(long id);
	TodoDTO notWorkCompleted(long id);
}
