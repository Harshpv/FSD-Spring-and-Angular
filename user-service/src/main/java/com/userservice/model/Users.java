package com.userservice.model;


//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Getter
//@Setter
//@ToString
@Data
@Document(collection = "Users")
public class Users {



    private String userName;
    @Id
    private String userEmailId;
    private String firstName;
    private String lastName;
    private String password;
    private Address address;


}
