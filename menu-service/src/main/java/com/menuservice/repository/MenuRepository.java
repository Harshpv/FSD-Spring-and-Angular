package com.menuservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.menuservice.datamodel.MenuModel;

//Inheriting mongorepository
public interface MenuRepository extends MongoRepository<MenuModel, Integer> {


}
