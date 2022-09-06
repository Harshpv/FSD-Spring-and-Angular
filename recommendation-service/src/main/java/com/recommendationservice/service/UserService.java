package com.recommendationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.exceptions.UserNotFoundException;
import com.recommendationservice.model.Menu;
import com.recommendationservice.model.User;
import com.recommendationservice.repository.UserRepository;

import com.recommendationservice.exceptions.UserAlreadyExistsException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getAll() throws UserNotFoundException {
		if (userRepository.count() == 0) {
			throw new UserNotFoundException();
		}
		return userRepository.getAllUsers();
	}

	public String addUser(User user) throws UserAlreadyExistsException {
		if (userRepository.findByUserId(user.getId()) == null) {
			userRepository.save(user);
			return "User Added Successfully!";
		}
		throw new UserAlreadyExistsException();
	}

	public User findById(Long id) throws UserNotFoundException {
		if (userRepository.findByUserId(id) != null) {
			return userRepository.findByUserId(id);
		}
		throw new UserNotFoundException();

	}

	public String updateUser(User user) throws UserNotFoundException {
//		return userRepository.findById(id);
		if (userRepository.findByUserId(user.getId()) != null) {
			userRepository.save(user);
			return "Updated Succesfully";
		}
		throw new UserNotFoundException();

	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public List<Menu> suggestByCity(String city) {
		return userRepository.suggestByCity(city);
	}
}
