package com.recommendationservice.model;


import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
@Data
@RelationshipProperties
public class RelationshipModel {
	@Id @GeneratedValue
	private Long id;
	private Long orderId;
	private String name;
	private User user;
	private Menu menu;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
////	public LocalDateTime getTime() {
////		return time;
////	}
////	public void setTime(LocalDateTime time) {
////		this.time = time;
////	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public Menu getMenu() {
//		return menu;
//	}
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}
//	public RelationshipModel(Long id, String name, User user, Menu menu, Long orderId) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.user = user;
//		this.menu = menu;
//		this.orderId= orderId;
//	}
//	public Long getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}

	
	
	
}
