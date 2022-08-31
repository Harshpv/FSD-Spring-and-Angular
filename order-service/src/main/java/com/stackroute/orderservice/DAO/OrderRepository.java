package com.stackroute.orderservice.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer > {

}
