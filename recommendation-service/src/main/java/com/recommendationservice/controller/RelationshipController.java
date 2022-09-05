package com.recommendationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendationservice.service.RelationshipService;
import com.recommendationservice.service.UserService;

@RestController
@RequestMapping("/api/v3")
public class RelationshipController {
	
	@Autowired
	RelationshipService relationshipService;
	
	@PostMapping("/{userId}/{itemId}")
	public void createRelationship(Long userId, Long itemId) {
		relationshipService.createRelationship(userId, itemId);
	}
	
}
