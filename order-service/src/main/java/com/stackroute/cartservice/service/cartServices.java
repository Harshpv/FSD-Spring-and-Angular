package com.stackroute.cartservice.service;

import com.stackroute.cartservice.Respository.CartRepository;
import com.stackroute.cartservice.exceptions.CartAlreadyExistsException;
import com.stackroute.cartservice.exceptions.CartNotFoundException;
import com.stackroute.cartservice.model.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class cartServices {
	//Calling cartRepository to use in creating wanted service.
	@Autowired
	private final CartRepository cartRepository;
	//private Cart cart;
	public cartServices(CartRepository cartRepository) {

		this.cartRepository = cartRepository;

	}
	 //addItemsToCart method consists of business logic to add new data to database
	public void addItemsToCart(Cart cart) throws CartAlreadyExistsException  {

		
		if (cartRepository.existsById(cart.getUserEmailId()))  {
			throw new CartAlreadyExistsException();
		}
		cartRepository.save(cart);
		log.info(" inside addItemsToCart");


	}
	//findAllCarts method consists of business logic to fetch all the data present in the database

	public List<Cart> findAllCarts() throws CartNotFoundException {

		log.info(" inside findAllCarts ");
		return cartRepository.findAll();

	}



	 
	 
	 // To update or save the cart using email Id
	 //saveOrUpdateItems method consists of business logic to update data already present in  database
	 public Cart saveOrUpdate(Cart cart) throws CartNotFoundException {


			if (cartRepository.existsById(cart.getUserEmailId())) {
				cartRepository.save(cart);
				log.info("inside saveOrUpdate!!");
				return cartRepository.save(cart);

			}

			throw new CartNotFoundException();
		}
	

//To find cart by using user email id method consists of business logic  to fetch specific data present in the database using userEmailId.
	 public Cart findCartByEmailId(String userEmailId) throws CartNotFoundException {

			if (
					cartRepository.existsById(userEmailId)) {

				return cartRepository.findById(userEmailId).get();
			}
            log.info("inside findCartByEmailId");
			throw new CartNotFoundException();

		}
	 

}
