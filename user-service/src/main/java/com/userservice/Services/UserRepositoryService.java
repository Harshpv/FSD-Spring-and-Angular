package com.userservice.Services;

import com.userservice.exceptiions.UserAlreadyExistsException;
import com.userservice.exceptiions.UserNotFoundException;
import com.userservice.model.Users;
import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryService {
    @Autowired
    private UserRepository repository;


    // this method is used to add new users to the database
    public Users addUser(Users user) throws UserAlreadyExistsException {
        if (repository.existsById(user.getUserEmailId())) {
            throw new UserAlreadyExistsException();
        }
        return repository.save(user);
    }

    // this method returns all the users from the database
    public List<Users> getUsers() throws UserNotFoundException {
        if (repository.count() == 0) {
            throw new UserNotFoundException();
        }
        return repository.findAll();
    }

    // this returns a specific user by users email id
    public Users getUserByEmail(String email) throws UserNotFoundException {
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
    public Users updateUser(Users user) throws UserNotFoundException {


        if (repository.existsById(user.getUserEmailId())) {
            Users users = repository.findById(user.getUserEmailId()).get();
            users.setUserEmailId(user.getUserEmailId());

            users.setFirstName(user.getFirstName());
            users.setLastName(user.getLastName());
            users.setPassword(user.getPassword());
            users.setAddress(user.getAddress());

            return repository.save(user);
        }
        throw new UserNotFoundException();


    }
 }

