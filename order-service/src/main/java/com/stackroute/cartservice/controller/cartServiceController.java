package com.stackroute.cartservice.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.cartservice.exceptions.CartAlreadyExistsException;
import com.stackroute.cartservice.exceptions.CartNotFoundException;
import com.stackroute.cartservice.model.Cart;
import com.stackroute.cartservice.service.Services;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Log4j
@RestController

@RequestMapping("/api/v1/cart")
public class cartServiceController {
	private final Services services ;
	private Cart cart;

	public cartServiceController(Services services) {

		this.services = services;
	}

	@PostMapping(value = "/create")
		public ResponseEntity<Object> addItemsToCart(@RequestBody Cart cart) {
		try {
			services.addItemsToCart(cart);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (CartAlreadyExistsException e) {

			return new ResponseEntity<>("Cart details already exists!!",HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Cart details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}
	
	
	
	@PutMapping("/{userEmailId}")
	public ResponseEntity<Object> saveOrUpdat(@RequestBody Cart cart) {
		try {

			services.saveOrUpdate(cart);
			return new ResponseEntity<>("Update success!!", HttpStatus.OK);

		} catch (CartNotFoundException e) {

			return new ResponseEntity<>("cart not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}
	
	@GetMapping("/{userEmailId}")
	public ResponseEntity<Cart> findCartByCartId(@PathVariable String userEmailId) {

		try {

			return new ResponseEntity(services.findCartByCartId(userEmailId), HttpStatus.OK);

		} catch (CartNotFoundException e) {

			return new ResponseEntity("Cart not found!!",HttpStatus.CONFLICT);
		} catch (Exception e) {

			return new ResponseEntity("Cart not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}



	@GetMapping
	public ResponseEntity<List<Cart>> findAllCarts() {
		try {
			return ResponseEntity.ok(services.findAllCarts());
		} catch (CartNotFoundException e) {
			return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
		}
	}

	}

    		
