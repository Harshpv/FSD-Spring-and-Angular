package com.recommendationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.repository.RelationshipRepository;

@Service
public class RelationshipService {
	@Autowired
	RelationshipRepository relationshipRepositrory;

	public void createRelationship(Long userId, Long itemId) {
		relationshipRepositrory.createRelationhip(userId, itemId);
	}
}
