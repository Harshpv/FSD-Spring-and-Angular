package com.recommendationservice.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;


@Node
public class User {
	
	@Id @Property private Long id;
	private String name;
	private String userEmailId;
	private String firstName;
	private String lastName;
	private Address address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public User(Long id, String name, String userEmailId, String firstName, String lastName, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.userEmailId = userEmailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	
	
	
	
}
