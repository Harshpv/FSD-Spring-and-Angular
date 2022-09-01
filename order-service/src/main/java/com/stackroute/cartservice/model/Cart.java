package com.stackroute.cartservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;




@Document(collection = "carts")
public class Cart {
	@Id
    private String userid;

    private @NonNull String userEmailId;

    @DBRef
    private @NonNull List<Menu> items;

	public Cart(String userid, String userEmailId, List<Menu> items) {
		super();
		this.userid = userid;
		this.userEmailId = userEmailId;
		this.items = items;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

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



		
	}



