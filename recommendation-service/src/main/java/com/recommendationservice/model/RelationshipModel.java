package com.recommendationservice.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class RelationshipModel {
	@RelationshipId @GeneratedValue
	Long id;
	String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RelationshipModel(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	private User user;
	@TargetNode
	private Menu menu;
	
}
