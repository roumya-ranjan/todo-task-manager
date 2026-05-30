package com.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.app.entity.Todo;
import com.todo.app.entity.User;
import com.todo.app.service.TodoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public String home(Model model, HttpSession session) {
		
		  System.out.println("TODOS PAGE HIT");

	    User user = (User) session.getAttribute("user");

	    if (user == null) {
	        return "redirect:/login";
	    }
	    
	    model.addAttribute("user", user);
	    model.addAttribute("todos", todoService.getTodosByUser(user));

	    return "todos";
	}
	
	@GetMapping("/add-todo")
	public String showAddForm(Model model) {
		
		Todo todo = new Todo();
		todo.setDueDate(java.time.LocalDateTime.now().plusDays(2));
		model.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@PostMapping("/save-todo")
	public String saveTodo(@ModelAttribute Todo todo, HttpSession session) {

	    User user = (User) session.getAttribute("user");

	    if (user == null) {
	        return "redirect:/login";
	    }

	    todo.setUser(user);
	    todoService.saveTodo(todo);

	    return "redirect:/todos";
	}
	
	@GetMapping("/edit-todo/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
	    Todo todo = todoService.getTodoById(id);
	    model.addAttribute("todo", todo);
	    return "add-todo";
	}
	
	@GetMapping("/delete-todo/{id}")
	public String deleteTodo(@PathVariable Long id, HttpSession session) {
		

	    User user = (User) session.getAttribute("user");
	    if (user == null) return "redirect:/login";
	    
	    System.out.println("Before delete count = " + todoService.getAllTodos().size());

	    Todo todo = todoService.getTodoById(id);

	    if (todo == null || todo.getUser() == null) {
	        return "redirect:/todos";
	    }

	    if (!todo.getUser().getId().equals(user.getId())) {
	        return "redirect:/todos";
	    }

	    todoService.deleteTodo(id);
	    System.out.println("After delete count = " + todoService.getAllTodos().size());

	    return "redirect:/todos";
	}
}
