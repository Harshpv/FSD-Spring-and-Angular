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
import com.recommendationservice.service.MenuService;
import com.recommendationservice.exceptions.MenuAlreadyExistsException;
import com.recommendationservice.exceptions.MenuNotFoundException;
import com.recommendationservice.model.Menu;

@RestController
@RequestMapping("/api/v2")
public class MenuController {
	@Autowired
	MenuService menuService;

	// Displays all Menu items present in the database.
	@GetMapping
	public ResponseEntity<Object> getAllMenu() {
		try {
			return ResponseEntity.ok(menuService.getAllMenu());
		} catch (MenuNotFoundException e) {
			return new ResponseEntity<Object>("No Menu item found was found in the database!", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/{itemId}")
	public ResponseEntity<Object> getById(@PathVariable Long itemId) {
		try {
			return new ResponseEntity<Object>(menuService.findByItemId(itemId), HttpStatus.OK);
		} catch (MenuNotFoundException e) {
			return new ResponseEntity<Object>("The requested menu could not be found.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Oops!Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping
	public ResponseEntity<?> addMenu(@RequestBody Menu menu) {
		try {
			menuService.addMenu(menu);

			return new ResponseEntity<>("Menu Added Successfully",HttpStatus.CREATED);
		} catch (MenuAlreadyExistsException e) {

			return new ResponseEntity<>("Item details already exist!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Oops. Something Went Wrong!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Provides Item Recommendation based on the food category provided
	@GetMapping("/category/{category}")
	public List<Menu> suggestByCity(@PathVariable String category) {
		return menuService.suggestByCity(category);

	}

	@DeleteMapping("/{Id}")
	public void deleteMenu(@PathVariable Long Id) {
		menuService.deleteMenu(Id);
	}

	@PutMapping
	public ResponseEntity<Object> updateMenu(@RequestBody Menu menu) {
//		return userService.findByName(name);
		try {
			menuService.updateMenu(menu);
			return new ResponseEntity<Object>("Menu Updated Successfully", HttpStatus.OK);
		} catch (MenuNotFoundException e) {
			return new ResponseEntity<Object>("The requested User could not be found.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Oops!Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
