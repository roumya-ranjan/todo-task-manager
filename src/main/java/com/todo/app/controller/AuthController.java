package com.todo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.app.entity.User;
import com.todo.app.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	 @Autowired
	    private UserService userService;
	 
	 @GetMapping("/")
	 public String root() {
	     return "redirect:/login";
	 }

	 
	 @GetMapping("/register")
	 public String registerPage(Model model) {
	     model.addAttribute("user", new User());
	     return "register";
	 }

	 @PostMapping("/register")
	 public String register(@ModelAttribute User user, Model model) {

	     // basic validation
	     if (user.getEmail() == null || user.getPassword() == null) {
	         model.addAttribute("error", "Email and Password are required");
	         return "register";
	     }

	     // check duplicate email
	     if (userService.getUserByEmail(user.getEmail()) != null) {
	         model.addAttribute("error", "Email already exists");
	         return "register";
	     }

	     userService.saveUser(user);

	     return "redirect:/login";
	 }	 
	 
	    @GetMapping("/login")
	    public String loginPage() {
	        return "login";
	    }

	    @PostMapping("/login")
	    public String login(@RequestParam String email,
	                        @RequestParam String password,
	                        HttpSession session, Model model) {

	        System.out.println(email);
	        System.out.println(password);

	        User user = userService.login(email, password);

	        System.out.println(user);

	        if (user != null) {
	            session.setAttribute("user", user);
	            return "redirect:/todos";
	        }
	        model.addAttribute("error", "Invalid email or password");

	        return "login";
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
}
