package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    private String userEmailId;
    private String firstName;
    private String lastName;
    private List<Address> address;
}
