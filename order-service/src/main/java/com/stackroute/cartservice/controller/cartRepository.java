package com.stackroute.cartservice.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.cartservice.model.Cart;


@Repository
public interface cartRepository extends MongoRepository<Cart, String> {
	
}
