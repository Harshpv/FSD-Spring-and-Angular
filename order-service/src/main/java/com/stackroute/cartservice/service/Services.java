package com.stackroute.cartservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.cartservice.Respository.CartRepository;
import com.stackroute.cartservice.exceptions.CartAlreadyExistsException;
import com.stackroute.cartservice.exceptions.CartNotFoundException;
import com.stackroute.cartservice.model.Cart;

@Service
public class Services {
	
	private final CartRepository cartRepository;
	private Cart cart;
	public  Services(CartRepository cartRepository) {

		this.cartRepository = cartRepository;
	}
	
	public void addItemsToCart(Cart cart) throws CartAlreadyExistsException  {

		
		if (cart.getUserEmailId() == cart.getUserEmailId())  {
			throw new CartAlreadyExistsException();
		}
		cartRepository.save(cart);

	}
	public List<Cart> findAllCarts() throws CartNotFoundException {

		
		return cartRepository.findAll();

	}



	 
	 
	 
	 public Cart saveOrUpdate(Cart cart) throws CartNotFoundException {

			Cart savedMenuModel = cartRepository.findById(cart.getUserEmailId()).get();
			if (cartRepository.existsById(cart.getUserEmailId())) {

				
				savedMenuModel.setUserEmailId(cart.getUserEmailId());
				savedMenuModel.setItems(cart.getItems());
				

				return cartRepository.save(cart);

			}

			throw new CartNotFoundException();
		}
	

	 public Cart findCartByCartId(String userEmailId) throws CartNotFoundException {

			if (
					cartRepository.existsById(userEmailId)) {

				return cartRepository.findById(userEmailId).get();
			}

			throw new CartNotFoundException();

		}
	 

}
