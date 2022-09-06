package com.authenticationservice.Userlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authenticationservice.Datamodel.UserDao;

public interface UserRepository extends JpaRepository<UserDao , String> {
//	UserDao save(String email);

}
