package com.stackroute.OrderService.service;

import org.springframework.stereotype.Service;

import com.stackroute.OrderService.Respository.OrderRepository;
import com.stackroute.OrderService.model.OrderModel;


@Service
public class OrderService {
	
	
	private OrderRepository orderRepository;

	
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}


	public void saveOrder(OrderModel or) {
		orderRepository.save(or);
	}

}
