package com.menuservice.controller;

import java.util.List;
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

import com.menuservice.datamodel.MenuModel;
import com.menuservice.exceptions.MenuAlreadyExistsException;
import com.menuservice.exceptions.MenuNotFoundException;
import com.menuservice.services.Services;



@RestController
@RequestMapping("/api/v1")
public class MenuController {
	
	//Calling services class and creating object to use further.
	private final Services services;
	
	//Calling menumodel class and creating object to use further.
	@SuppressWarnings("unused")
	private MenuModel menuModel;

	public MenuController(Services services) {

		this.services = services;
	}

	//Postmapping api used to post data to the mongo database. 
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
	
	//Putmapping api used to update data which already exists in the mongo database. 
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
	
	//Getmapping api used to fetch all the data  present in the mongo database. 
	@GetMapping
	public ResponseEntity<List<MenuModel>> getItems() {
		try {
			return ResponseEntity.ok(services.getItems());
		} catch (MenuNotFoundException e) {
			return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
		}
	}
	//Getmapping  api with id used to fetch specific data with it's id, present in the mongo database.
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

	//Deletemapping api with id used to delete specific data with it's id, present in the mongo database
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
