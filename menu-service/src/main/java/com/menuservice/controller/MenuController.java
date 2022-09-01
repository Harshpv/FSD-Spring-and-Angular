package com.menuservice.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuservice.datamodel.MenuModel;
import com.menuservice.exceptions.MenuAlreadyExistsException;
import com.menuservice.exceptions.MenuNotFoundException;
import com.menuservice.repository.MenuRepository;
import com.menuservice.services.Services;

import lombok.extern.log4j.Log4j;
//import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import java.util.logging.Level;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Log4j
public class MenuController {

	private final Services services;

	private MenuModel menuModel;

	public MenuController(Services services) {

		this.services = services;
	}

	@PostMapping
	public ResponseEntity addItems(@RequestBody MenuModel menuModel) {

		try {
			services.addItems(menuModel);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (MenuAlreadyExistsException e) {

			return new ResponseEntity<>("Item details already exists!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Item details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{itemId}")
	public ResponseEntity<Object> updateItem(@RequestBody MenuModel menuModel) {
		try {

			services.updateItem(menuModel);
			return new ResponseEntity<>("Update success!!", HttpStatus.OK);

		} catch (MenuNotFoundException e) {

			return new ResponseEntity<>("Menu not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping
	public ResponseEntity<List<MenuModel>> getItems() {
		try {
			return ResponseEntity.ok(services.getItems());
		} catch (MenuNotFoundException e) {
			return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/{itemId}")
	public ResponseEntity<MenuModel> getItemsById(@PathVariable int itemId) {

		try {

			return new ResponseEntity(services.getItemsById(itemId), HttpStatus.OK);

		} catch (MenuNotFoundException e) {

			return new ResponseEntity("Menu not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {

			return new ResponseEntity("Menu not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{itemId}")
	public void deleteItem(@PathVariable int itemId) {
		try {

			this.services.deleteById(itemId);

		} catch (MenuNotFoundException e) {

			System.out.println("Not found");

			ResponseEntity.status(HttpStatus.NO_CONTENT);
		} catch (Exception e) {

			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	private void ResponseEntity(String string, HttpStatus conflict) {
		// TODO Auto-generated method stub

	}


}
