package com.example.demo.service.implementations;

import java.util.Optional;


import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.automappers.AutoUserMapper;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public Users createUsers(Users users) {
		// TODO Auto-generated method stub
		return userRepo.save(users);
	}
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Users users = modelMapper.map(userDTO, Users.class);
		Users saved = userRepo.save(users);
		UserDTO dto = modelMapper.map(saved, UserDTO.class);
		System.out.println(dto.getEmail());
		return dto;
	}
	@Override
	public Users userCreate(UserDTO userDTO) {
		// TODO Auto-generated method stub
		Users users = AutoUserMapper.MAPPERS.mapToDTO(userDTO);
		Users ax = userRepo.save(users);
		UserDTO dto = AutoUserMapper.MAPPERS.mapToEntity(ax);
		return ax;
	}
	@Override
	public UserDTO createsUser(Users users) {
		// TODO Auto-generated method stub
		Users users2 = AutoUserMapper.MAPPERS.mapToDTO(modelMapper.map(users, UserDTO.class));
		Users ae = userRepo.save(users2);
		UserDTO dto = AutoUserMapper.MAPPERS.mapToEntity(ae);
		return dto;
	}
	@Override
	public Users getUserdetailsById(long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}
	@Override
	public UserDTO getDetailsById(long id) {
		// TODO Auto-generated method stub
		Optional<Users> ax = userRepo.findById(id);
		UserDTO dtos = modelMapper.map(ax, UserDTO.class);
		return dtos;
	}
	@Override
	public Users updateUser(Users users) {
		// TODO Auto-generated method stub
		Users u = userRepo.findById(users.getId()).get();
		u.setEmail(users.getEmail());
		u.setFname(users.getFname());
		u.setId(users.getId());
		u.setLname(users.getLname());
		Users ax = userRepo.save(u);
		return ax;
	}
	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}
	
	
	
	
	

	
	
	


	


	

}
