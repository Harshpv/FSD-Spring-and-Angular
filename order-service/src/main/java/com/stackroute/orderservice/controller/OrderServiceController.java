package com.stackroute.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.orderservice.DAO.OrderRepository;
import com.stackroute.orderservice.model.Order;



@RestController
@RequestMapping("/api/v1")
public class OrderServiceController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		
		return new ResponseEntity<Order>(orderRepository.save(order), HttpStatus.CREATED);
	}
	
	//get by order id
	//get all
	//delete order
	//put order
}
