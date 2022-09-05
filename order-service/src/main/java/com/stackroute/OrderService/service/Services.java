package com.stackroute.OrderService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.OrderService.Respository.CartRepository;
import com.stackroute.OrderService.exceptions.CartAlreadyExistsException;
import com.stackroute.OrderService.exceptions.CartNotFoundException;
import com.stackroute.OrderService.model.Cart;

@Service
public class Services {
	
	private final CartRepository cartRepository;
	private Cart cart;
	public  Services(CartRepository cartRepository) {

		this.cartRepository = cartRepository;
	}
	// To get add new items  to cart
	public void addItemsToCart(Cart cart) throws CartAlreadyExistsException  {

		
		if (cart.getUserEmailId() == cart.getUserEmailId())  {
			throw new CartAlreadyExistsException();
		}
		cartRepository.save(cart);

	}
	// to find all the carts 
	public List<Cart> findAllCarts() throws CartNotFoundException {

		
		return cartRepository.findAll();

	}



	 
	 
	 // To update or save the cart using email Id
	 public Cart saveOrUpdate(Cart cart) throws CartNotFoundException {

			Cart savedMenuModel = cartRepository.findById(cart.getUserEmailId()).get();
			if (cartRepository.existsById(cart.getUserEmailId())) {

				
				savedMenuModel.setUserEmailId(cart.getUserEmailId());
				savedMenuModel.setItems(cart.getItems());
				

				return cartRepository.save(cart);

			}

			throw new CartNotFoundException();
		}
	
// To find cart by using user email id
	 public Cart findCartByEmailId(String userEmailId) throws CartNotFoundException {

			if (
					cartRepository.existsById(userEmailId)) {

				return cartRepository.findById(userEmailId).get();
			}

			throw new CartNotFoundException();

		}
	 

}
