package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "Users")
<<<<<<< HEAD:user-service/src/main/java/com/userservice/model/User.java
public class User {
=======
public class Users {
>>>>>>> 6dda1f72c6dd5f04566ff19056c12e38211b6400:user-service/src/main/java/com/userservice/model/Users.java

    @Id
    private String userEmailId;
    private String mobileNum;
    private String firstName;
    private String lastName;
    private List<Address> address;
<<<<<<< HEAD:user-service/src/main/java/com/userservice/model/User.java
=======

>>>>>>> 6dda1f72c6dd5f04566ff19056c12e38211b6400:user-service/src/main/java/com/userservice/model/Users.java
}
