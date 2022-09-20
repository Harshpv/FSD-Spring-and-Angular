package com.userservice.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {


    private String userEmailId;
    private String mobileNum;
    private String firstName;
    private String lastName;
    private String password;

    private List<Address> address;


}
