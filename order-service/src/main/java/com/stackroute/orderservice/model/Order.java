package com.stackroute.orderservice.model;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
public class Order {
	
	//@Id
	private int orderId; //unique Id for each order
	private int userId;	 //obtain from userservice mongodb
	private int payment; //total price for items
//	private LocalDateTime time; //time at which user ordered
//	private LocalDateTime orderScheduleTime; //time at which order will be delivered
	//private List<Menu> itemsList; //list of items
	
	
	public Order() {
		super();
		//this.time=LocalDateTime.now();
		//this.orderScheduleTime=this.time.plusMinutes(30);		
	}
	public Order(int orderId, int userId, int payment) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.payment = payment;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	/*public LocalDateTime getTime() {
		return time;
	}*/

	/*public LocalDateTime getOrderScheduleTime() {
		return orderScheduleTime;
	}*/
	
	/*@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", payment=" + payment + ", time=" + time
				+ ", orderScheduleTime=" + orderScheduleTime + "]";
	}*/

	/*public List<Menu> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Menu> itemsList) {
		this.itemsList = itemsList;
	}*/
	
}

