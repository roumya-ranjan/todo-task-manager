package com.todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
