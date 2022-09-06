package com.stackroute.OrderService.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class OrderModel {
	
	@Id
	private int orderId; //unique Id for each order

	@NonNull
	private int userId;	 //obtain from userservice mongodb

	@NonNull
	private int payment; //total price for items

	@Setter(AccessLevel.NONE)
	private LocalDateTime time; //time at which user ordered

	@Setter(AccessLevel.NONE)
	private LocalDateTime orderScheduleTime; //time at which order will be delivered


	private List<Menu> itemsList; //list of items
	
	public OrderModel() {
		super();
		this.time=LocalDateTime.now();
		this.orderScheduleTime=this.time.plusMinutes(30);		
	}

	public OrderModel(int orderId, @NonNull int userId, @NonNull int payment, List<Menu> itemsList) {
		this.orderId = orderId;
		this.userId = userId;
		this.payment = payment;
		this.itemsList = itemsList;
	}

}
