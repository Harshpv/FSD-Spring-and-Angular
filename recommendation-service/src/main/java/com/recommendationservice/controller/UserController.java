package com.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendationservice.model.User;
import com.recommendationservice.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	@GetMapping("/{name}")
	public User getByName(@PathVariable String name) {
		return userService.findByName(name);
	}
	@DeleteMapping("/{Id}")
	public void deleteUser(@PathVariable Long Id) {
		userService.deleteUser(Id);
	}

}
