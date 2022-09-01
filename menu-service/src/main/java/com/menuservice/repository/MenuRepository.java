package com.menuservice.repository;

import java.awt.Menu;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.menuservice.datamodel.MenuModel;

public interface MenuRepository extends MongoRepository<MenuModel, Integer> {

//	@Query("{'name':?0}")
//	Optional<MenuModel> findByName(String name);
//
////	@Query("{'name':?0}")
////	Optional<MenuModel> deleteByName(String name);
//	
}
