package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;
import java.util.List;


public interface UserRepo extends JpaRepository<Users,Long> {

}
