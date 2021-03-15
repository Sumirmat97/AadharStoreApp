package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("user")
	List<User> getAllUsers(@RequestParam String filter, @RequestParam String keyword)
	{
		return service.getAllUsers(filter, keyword);
	}
	
	@PostMapping("user")
	String createUser(@RequestBody User user)
	{
		return "";
	}
	
	@GetMapping("user/{id}")
	User getUser(@PathVariable Long id) {
		return service.getUser(id);
	}
	
}
