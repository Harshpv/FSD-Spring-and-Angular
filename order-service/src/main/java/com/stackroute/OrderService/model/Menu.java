package com.stackroute.OrderService.model;

import lombok.Data;

@Data
public class Menu {
	int itemId;
	String itemName;
	String itemDescription;
	boolean isVeg;
	long itemCost;
	String image;
	public Menu(int itemId, String itemName, String itemDescription, boolean isVeg, long itemCost, String image) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.isVeg = isVeg;
		this.itemCost = itemCost;
		this.image = image;
	}
	
}
