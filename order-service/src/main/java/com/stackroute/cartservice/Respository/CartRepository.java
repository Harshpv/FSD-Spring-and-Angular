package com.stackroute.cartservice.Respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.cartservice.model.Cart;
import com.stackroute.cartservice.model.Menu;



@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

	

	


	
	




	
}
