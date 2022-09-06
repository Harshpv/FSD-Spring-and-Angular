package com.stackroute.OrderService.service;

import com.stackroute.OrderService.exceptions.OrderAlreadyExistsException;
import com.stackroute.OrderService.exceptions.OrderNotFoundException;
import org.springframework.stereotype.Service;

import com.stackroute.OrderService.Respository.OrderRepository;
import com.stackroute.OrderService.model.OrderModel;


import java.util.List;



@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public void addOrder(OrderModel orderModel) throws OrderAlreadyExistsException {
		if(orderRepository.existsById(orderModel.getOrderId())){
			throw new OrderAlreadyExistsException();		
		}
		orderRepository.insert(orderModel);
	}

    public List<OrderModel> getOrders() throws OrderNotFoundException {
		if(orderRepository.findAll().isEmpty()){
			throw new OrderNotFoundException();
		}
		return orderRepository.findAll();
    }

	public OrderModel getOrderById(int orderId) throws OrderNotFoundException {

			if (orderRepository.findById(orderId).isPresent()) {
				return orderRepository.findById(orderId).get();
			}
			else{
				throw new OrderNotFoundException();
			}
	}

	public void deleteByOrderId(int orderId) throws OrderNotFoundException {
		if (orderRepository.findById(orderId).isPresent()) {
			orderRepository.deleteById(orderId);
		}
		else{
			throw new OrderNotFoundException();
		}
	}


	public void updateOrder(OrderModel orderModel) throws OrderNotFoundException {
		if(orderRepository.findById(orderModel.getOrderId()).isEmpty()){
			throw new OrderNotFoundException();
		}
		orderRepository.save(orderModel);
	}
}
