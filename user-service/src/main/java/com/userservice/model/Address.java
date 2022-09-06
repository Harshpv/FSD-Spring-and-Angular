package com.userservice.model;

public class Address {

    private int houseId;
    private String houseNum;
    private String street;
    private String city;
    private String state;
    private Long pincode;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
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

    public Address(int houseId, String houseNum, String street, String city, String state, Long pincode) {
        this.houseId = houseId;
        this.houseNum = houseNum;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
