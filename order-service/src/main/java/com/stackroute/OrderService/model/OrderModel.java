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

	private String userEmailId;

	@Setter(AccessLevel.NONE)
	private int totalPrice = 0; //total price for items, generates logically

	@Setter(AccessLevel.NONE)
	private LocalDateTime time; //time at which user ordered

	@Setter(AccessLevel.NONE)
	private LocalDateTime orderScheduleTime; //time at which order will be delivered


	private List<Menu> itemsList; //list of items

	public OrderModel() {
		super();
		this.time = LocalDateTime.now();
		this.orderScheduleTime = this.time.plusMinutes(30);

	}

	public OrderModel(int orderId, String userEmailId, List<Menu> itemsList) {
		this.orderId = orderId;
		this.userEmailId = userEmailId;
		this.itemsList = itemsList;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (Menu item : this.itemsList) {
			sum = (int) (sum + item.itemCost*item.qty);
		}
		this.totalPrice = sum;
		return this.totalPrice;
	}
}