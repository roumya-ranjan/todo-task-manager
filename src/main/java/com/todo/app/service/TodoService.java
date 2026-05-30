package com.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.app.entity.Todo;
import com.todo.app.entity.User;
import com.todo.app.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;
	
	public Todo saveTodo(Todo todo) {
		return todoRepo.save(todo);
	}
	
	public List<Todo> getTodosByUser(User user){
		return todoRepo.findByUser(user);
	}
	
	public List<Todo> getAllTodos(){
		return todoRepo.findAll();
	}
	
	public void deleteTodo(Long id) {
	    todoRepo.findById(id).ifPresent(todoRepo::delete);
	}
	
	public Todo getTodoById(Long id) {
		return todoRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("Todo not found"));
	}
	
	
}
