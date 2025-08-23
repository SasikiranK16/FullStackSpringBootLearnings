package com.example.demo.controllers;

import org.apache.catalina.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.automappers.AutoUserMapper;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@RestController
public class UserControllers {

    private final UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	private AutoUserMapper MAPPERS;

    UserControllers(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
	@PostMapping("/api/create/user")
	public ResponseEntity<Users>createNewUser(@RequestBody Users users){
		Users savedData = userService.createUsers(users);
		return new ResponseEntity<>(savedData,HttpStatus.CREATED);
	}
	@PostMapping("/api/tests")
	public ResponseEntity<UserDTO>createPosts(@RequestBody UserDTO dto){
		return new ResponseEntity<>(userService.createUser(dto),HttpStatus.CREATED);
	}
	@PostMapping("/api/test")
	public ResponseEntity<Users>testCreate(@RequestBody UserDTO userDTO){
		return new ResponseEntity<>(userService.userCreate(userDTO),HttpStatus.CREATED);
	}
	@PostMapping("/api/test/user")
	public ResponseEntity<UserDTO>creates(@RequestBody Users users){
		return new ResponseEntity<>(userService.createsUser(users),HttpStatus.CREATED);
	}
	@PostMapping("/api/test/dto")
	public ResponseEntity<UserDTO>created(@RequestBody Users users){
		return new ResponseEntity<>(userService.createsUser(users),HttpStatus.CREATED);
	}
	@GetMapping("/api/{id}")
	public ResponseEntity<Users>getDetails(@PathVariable("id")long id){
		return new ResponseEntity<>(userService.getUserdetailsById(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/apis/{id}")
	public ResponseEntity<UserDTO>gets(@PathVariable("id")long id){
		return new ResponseEntity<>(userService.getDetailsById(id),HttpStatus.OK);
	}
	@PutMapping("/api/update")
	public ResponseEntity<Users>testUpdate(@RequestBody Users users){
		return new ResponseEntity<Users>(userService.updateUser(users),HttpStatus.OK);
	}
	@DeleteMapping("/api/remove/{id}")
	public ResponseEntity<String>delete(@PathVariable("id")long id){
		userService.deleteUser(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
}
