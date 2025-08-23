package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entity.Users;

public interface UserService {

	Users createUsers(Users users);
	UserDTO createUser(UserDTO userDTO);
	Users userCreate(UserDTO userDTO);
	UserDTO createsUser(Users users);
	Users getUserdetailsById(long id);
	UserDTO getDetailsById(long id);
	Users updateUser(Users users);
	void deleteUser(long id);
}
