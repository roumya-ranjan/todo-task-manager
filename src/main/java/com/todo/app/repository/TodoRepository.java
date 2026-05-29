package com.todo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.entity.Todo;
import com.todo.app.entity.User;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	List<Todo> findByUser(User user);

}
