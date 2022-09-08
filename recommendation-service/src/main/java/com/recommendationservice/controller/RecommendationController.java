package com.recommendationservice.controller;

import com.recommendationservice.model.Menu;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.recommendationservice.exceptions.UserNotFoundException;
import com.recommendationservice.model.RelationshipModel;
import com.recommendationservice.model.User;
import com.recommendationservice.service.MenuService;
import com.recommendationservice.service.RelationshipService;
import com.recommendationservice.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/v4")
public class RecommendationController {
	
	@Autowired
	RelationshipService relationshipService;
	@Autowired
	UserService userService;
	@Autowired
	MenuService menuService;
	
	@GetMapping("/city/{city}")
	public List<Menu> suggestByCity(@PathVariable String city){
		List<Long> usersIdList = new  ArrayList<Long>();
		List<Long> ordersIdList = new  ArrayList<Long>();
		List<Menu> menuList = new ArrayList<Menu>();

		List<User> usersList = userService.suggestByCity(city);
		for(int i = 0; i<usersList.size();i++) {
			usersIdList.add(usersList.get(i).getId());
			
		}
//		List<Long> orderIdList  = new ArrayList<Long>();
		for (int i = 0;i<usersIdList.size();i++) {
			List<RelationshipModel> orderList = relationshipService.getallOrdersByUserId(usersIdList.get(i));
			for(int j = 0; j<orderList.size();j++) {
				ordersIdList.add(orderList.get(j).getOrderId());
			}
		}
		for (int i=0; i<ordersIdList.size();i++) {
			menuList.add(menuService.getByOrder(ordersIdList.get(i)));
			
		}
		return menuList;
		
	}

}
