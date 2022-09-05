package com.recommendationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.model.User;
import com.recommendationservice.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAll(){
		return userRepository.getAllUsers();
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	public void userOrdered(Long userId,Long menuId ) {
		
	}
}	

