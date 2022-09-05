package com.recommendationservice.model;

import org.springframework.data.neo4j.core.schema.Id;

public class Address {
	@Id
	private Integer houseId;
	private String houseNum;
	private String street;
	private String city;
	private String state;
	private Long pincode;
	public Address(Integer houseId, String houseNum, String street, String city, String state, Long pincode) {
		super();
		this.houseId = houseId;
		this.houseNum = houseNum;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
	

}
