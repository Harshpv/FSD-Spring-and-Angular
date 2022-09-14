package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "Users")
public class Users {

    @Id
    private String userEmailId;
//    private String mobileNum;
    private String firstName;
    private String lastName;
    private List<Address> address;
}
