package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private int houseId;
    private String addressType;
    private String houseNum;
    private String street;
    private String city;
    private String state;
    private Long pincode;

}
