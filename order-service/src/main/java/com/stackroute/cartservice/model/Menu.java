package com.stackroute.cartservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menu")
public class Menu {
	int itemId;
	String itemName;
	String itemDescription;
	String category;
	long itemCost;
	String itemImage;
	int Quantity;

}
