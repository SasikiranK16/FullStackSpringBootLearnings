package com.example.demo.service.implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.automappers.AutoUserMapper;
import com.example.demo.dtos.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.repo.TodoRepo;
import com.example.demo.service.TodoService;
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepo todoRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public TodoDTO createTodo(TodoDTO todoDTO) {
		// TODO Auto-generated method stub
		Todo todo = modelMapper.map(todoDTO, Todo.class);
		Todo ax = todoRepo.save(todo);
		TodoDTO dto = modelMapper.map(ax, TodoDTO.class);
		return dto;
	}
	@Override
	public List<Todo> getAllTodos() {
		// TODO Auto-generated method stub
		return todoRepo.findAll();
	}
	@Override
	public TodoDTO getTodosById(long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id).get();
		return modelMapper.map(todo, TodoDTO.class);
	}
	@Override
	public TodoDTO updateTodoById(long id,TodoDTO dto) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id).orElse(null);
		todo.setTitle(dto.getTitle());
		todo.setDescription(dto.getDescription());
		todo.setCompleted(dto.isCompleted());
		Todo savedUpdated = todoRepo.save(todo);
		return modelMapper.map(savedUpdated, TodoDTO.class);
	}
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		todoRepo.deleteById(id);
	}
	@Override
	public TodoDTO isWorkCompleted(long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id).orElse(null);
		todo.setCompleted(Boolean.TRUE);
		Todo saved = todoRepo.save(todo);
		return AutoUserMapper.MAPPERS.mapToEntity(saved);
	}
	@Override
	public TodoDTO notWorkCompleted(long id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id).orElse(null);
		todo.setCompleted(Boolean.FALSE);
		Todo saved = todoRepo.save(todo);
		return AutoUserMapper.MAPPERS.mapToEntity(todo);
	}


}
