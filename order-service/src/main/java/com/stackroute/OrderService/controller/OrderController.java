package com.stackroute.OrderService.controller;


import com.stackroute.OrderService.exceptions.OrderAlreadyExistsException;
import com.stackroute.OrderService.exceptions.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.OrderService.model.OrderModel;
import com.stackroute.OrderService.service.OrderService;



@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	
	private final OrderService service;
	
	public OrderController(OrderService service) {
		super();
		this.service = service;
	}


	@PostMapping("/addOrder")
	public ResponseEntity<Object> postOrder(@RequestBody OrderModel order){
		try {
			service.addOrder(order);
			return new ResponseEntity<>("Order added!",HttpStatus.CREATED);
		} catch (OrderAlreadyExistsException e) {
			return new ResponseEntity<>("Order already exists", HttpStatus.CONFLICT);
		} catch (Exception e){
			return new ResponseEntity<>("Order not added",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getOrders")
	public ResponseEntity<Object> getOrders(){

		try {
			return ResponseEntity.ok(service.getOrders());
		} catch (OrderNotFoundException e) {
			return new ResponseEntity<Object>("orders not found",HttpStatus.CONFLICT);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<Object> getOrderById(@PathVariable("orderId") int orderId){

		try {
			return new ResponseEntity<Object>(service.getOrderById(orderId),HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			return new ResponseEntity<>("Order not found",HttpStatus.CONFLICT);
		} catch(Exception e){
			return new ResponseEntity<>("Not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<Object> updateOrder(@RequestBody OrderModel orderModel){
		try {
			service.updateOrder(orderModel);
			return new ResponseEntity<Object>("Order updated!!",HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			return new ResponseEntity<>("Order not exists",HttpStatus.CONFLICT);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<Object> deleteOrderByOrderId(@PathVariable int orderId){
		try {
			service.deleteByOrderId(orderId);
			return new ResponseEntity<>("Order deleted",HttpStatus.OK);
		} catch (OrderNotFoundException e) {
			return new ResponseEntity<>("Order not found",HttpStatus.CONFLICT);
		} catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
