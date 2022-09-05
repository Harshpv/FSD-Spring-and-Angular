package com.stackroute.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired
;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.OrderService.model.OrderModel;
import com.stackroute.OrderService.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	@Autowired
	private OrderService service;


	
	@PostMapping("/save")
	public ResponseEntity<OrderModel> postOrder(@RequestBody OrderModel order){
		service.saveOrder(order);
		return new ResponseEntity<OrderModel>(HttpStatus.CREATED);
	}
	
	

}
