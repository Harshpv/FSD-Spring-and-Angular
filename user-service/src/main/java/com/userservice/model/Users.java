package com.userservice.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection = "Users")
public class Users {




    @Id
    private String userEmailId;
    private String firstName;
    private String lastName;
    private String password;
    private List<Address> address;


}
