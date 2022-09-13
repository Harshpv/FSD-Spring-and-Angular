package com.userservice.Services;

import com.userservice.exceptiions.UserAlreadyExistsException;
import com.userservice.exceptiions.UserNotFoundException;
import com.userservice.model.User;
import com.userservice.model.UserModel;
import com.userservice.model.UsersDTO;
import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserRepositoryService {
    @Autowired
    private UserRepository repository;
    private User userDemo;


    public String publishMessage(@RequestBody UserModel credentials) {
                return "Message Published";
    }

    // this method is used to add new users to the database
    public User addUser(UsersDTO user) throws UserAlreadyExistsException {
        if (repository.existsById(user.getUserEmailId())) {
            throw new UserAlreadyExistsException();
        }
        userDemo = new User(user.getUserEmailId(), user.getFirstName(), user.getLastName(), user.getAddress());
//        userDemo.setUserEmailId(user.getUserEmailId());
//        userDemo.setFirstName(user.getFirstName());
//        userDemo.setLastName(user.getLastName());
//        userDemo.setAddress(user.getAddress());
        return repository.save(userDemo);
    }

    // this method returns all the users from the database
    public List<User> getUsers() throws UserNotFoundException {
        if (repository.count() == 0) {
            throw new UserNotFoundException();
        }
        return repository.findAll();
    }

    // this returns a specific user by users email id
    public User getUserByEmail(String email) throws UserNotFoundException {
        if(repository.existsById(email)) {
            return repository.findById(email).get();
        }
        throw new UserNotFoundException();
    }

    // this method is used to delete an user by his email id
    public void deleteUserByEmail(String email) throws UserNotFoundException {
        if(repository.existsById(email)) {
           repository.deleteById(email);
        }
        throw new UserNotFoundException();
    }

    // this method is used to update user details
    public User updateUser(UsersDTO user) throws UserNotFoundException {


        if (repository.existsById(user.getUserEmailId())) {
            User users = repository.findById(user.getUserEmailId()).get();
            users.setUserEmailId(user.getUserEmailId());

            users.setFirstName(user.getFirstName());
            users.setLastName(user.getLastName());

            users.setAddress(user.getAddress());

            return repository.save(users);
        }
        throw new UserNotFoundException();


    }
 }

