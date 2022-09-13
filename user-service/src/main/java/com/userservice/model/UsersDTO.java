package com.userservice.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@Data
@NoArgsConstructor
public class UsersDTO {


    private String userEmailId;
    private String firstName;
    private String lastName;
    private String password;

    private List<Address> address;


}
