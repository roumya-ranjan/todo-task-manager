package com.todo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.app.entity.Todo;
import com.todo.app.entity.User;
import com.todo.app.repository.TodoRepository;

@Service
public class TodoService {

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
	
	public void deleteTodo(long id) {
		todoRepo.deleteById(id);
	}
	
	public Todo getTodoByTodo(Long id) {
		return todoRepo.findById(id).orElse(null);
	}
	
	
}
