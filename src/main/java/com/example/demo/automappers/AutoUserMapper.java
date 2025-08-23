package com.example.demo.automappers;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

import com.example.demo.dtos.AccountDTO;
import com.example.demo.dtos.TodoDTO;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Todo;
import com.example.demo.entity.Users;

@Mapper
public interface AutoUserMapper {

	AutoUserMapper MAPPERS = Mappers.getMapper(AutoUserMapper.class);
	Users mapToDTO(UserDTO userDTO);
	UserDTO mapToEntity(Users users);
	Account mapToEntity(AccountDTO accountDTO);
	AccountDTO mapToDTO(Account account);
	Todo mapToTodoDTO(TodoDTO todoDTO);
	TodoDTO mapToEntity(Todo todo);
}
