package com.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendationservice.model.Menu;
import com.recommendationservice.model.RelationshipModel;
import com.recommendationservice.service.RelationshipService;

@RestController
@RequestMapping("/api/v3")
public class RelationshipController {
	
	@Autowired
	RelationshipService relationshipService;
	
	@PostMapping
	public void createRelationship(@RequestBody RelationshipModel relationship) {
		relationshipService.createRelationship(relationship);
	}
	@GetMapping
	public List<Menu> suggestByCity(@RequestBody RelationshipModel relationship){
		return relationshipService.suggestByCity(relationship);
	}
	
}
