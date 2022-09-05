package com.stackroute.OrderService.controller;

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

import com.stackroute.OrderService.exceptions.CartAlreadyExistsException;
import com.stackroute.OrderService.exceptions.CartNotFoundException;
import com.stackroute.OrderService.model.Cart;
import com.stackroute.OrderService.service.Services;

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
//To get add new items  to cart by post mapping
	@PostMapping(value = "/create")
		public ResponseEntity<Object> addItemsToCart(@RequestBody Cart cart) {
		try {
			services.addItemsToCart(cart);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (CartAlreadyExistsException e) {

			return new ResponseEntity<>("Cart  already exists!!",HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Cart details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}
	
	
	//To update or save the cart using email Id
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
	// To find cart by using user email id 
	@GetMapping("/{userEmailId}")
	public ResponseEntity<Cart> findCartByEmailId(@PathVariable String userEmailId) {

		try {

			return new ResponseEntity(services.findCartByEmailId(userEmailId), HttpStatus.OK);

		} catch (CartNotFoundException e) {

			return new ResponseEntity("Cart not found!!",HttpStatus.CONFLICT);
		} catch (Exception e) {

			return new ResponseEntity("Cart not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	//to find all the carts 
	@GetMapping
	public ResponseEntity<List<Cart>> findAllCarts() {
		try {
			return ResponseEntity.ok(services.findAllCarts());
		} catch (CartNotFoundException e) {
			return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
		}
	}

	}

    		
