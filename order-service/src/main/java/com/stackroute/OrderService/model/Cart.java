package com.stackroute.OrderService.model;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mongodb.lang.NonNull;




@Document(collection = "carts")
public class Cart {
	
    @Id
    private @NonNull String userEmailId;

    
    private @NonNull List<Menu> items;

	

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public List<Menu> getItems() {
		return items;
	}

	public void setItems(List<Menu> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [ userEmailId=" + userEmailId + ", items=" + items + "]";
	}

	public Cart( String userEmailId, List<Menu> items) {
		super();
		
		this.userEmailId = userEmailId;
		this.items = items;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

 
	



		
	}



