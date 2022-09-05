package com.recommendationservice.model;

import org.springframework.data.neo4j.core.schema.Id;
import com.recommendationservice.model.Address;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class User {
	@Id
	private Long userId;
	private String name;
	private String userEmailId;
	private String firstName;
	private String lastName;
	private Address address;
	public User(Long userId, String name, String userEmailId, String firstName, String lastName,
			Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.userEmailId = userEmailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String userName) {
		this.name = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
