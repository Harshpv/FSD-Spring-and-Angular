package com.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendationservice.exceptions.UserNotFoundException;
import com.recommendationservice.model.Menu;
import com.recommendationservice.model.User;
import com.recommendationservice.service.UserService;

import com.recommendationservice.exceptions.UserAlreadyExistsException;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<Object> getAll() {
		try {
			return ResponseEntity.ok(userService.getAll());
		} catch (UserNotFoundException e) {
			return new ResponseEntity<Object>("No User found was found in the database!", HttpStatus.CONFLICT);
		}
	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);

			return new ResponseEntity<>("User Added Successfully!",HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {

			return new ResponseEntity<>("User details already exist!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Oops. Something Went Wrong!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(userService.findById(id), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<Object>("The requested User could not be found.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Oops!Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{Id}")
	public void deleteUser(@PathVariable Long Id) {
		userService.deleteUser(Id);
	}

	@GetMapping("/city/{city}")
	public List<Menu> suggestByCity(@PathVariable String city) {
		return userService.suggestByCity(city);

	}

	@PutMapping()
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		try {
			userService.updateUser(user);
			return new ResponseEntity<Object>("Updated Successfully", HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<Object>("The requested User could not be found.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Oops!Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
