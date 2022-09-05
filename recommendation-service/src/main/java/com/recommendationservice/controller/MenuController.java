package com.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recommendationservice.service.MenuService;
import com.recommendationservice.model.Menu;

@RestController
@RequestMapping("/api/v2")
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@GetMapping
	public List<Menu> getAllMenu(){
		return menuService.getAllMenu();
	}
	
	@PostMapping
	public void addMenu(@RequestBody Menu menu) {
		menuService.addMenu(menu);
	}
}
