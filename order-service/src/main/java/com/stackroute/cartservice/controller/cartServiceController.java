package com.stackroute.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.cartservice.model.Cart;




@RestController

@RequestMapping("/api/v1/cart")
public class cartServiceController {
	@Autowired
	private cartRepository cartRepository;

    @PostMapping(value = "/")
    private ResponseEntity<?> addCart(@RequestBody Cart Cart) {
		Cart save = this.cartRepository.save(Cart);
		return ResponseEntity.ok(save);}
		
	 @GetMapping(value = "/")
		    private ResponseEntity<?> getCarts() {
				
				return ResponseEntity.ok(this.cartRepository.findAll());	
    	
    }
}