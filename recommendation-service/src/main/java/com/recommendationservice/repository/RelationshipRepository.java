package com.recommendationservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.recommendationservice.model.RelationshipModel;
import com.recommendationservice.model.User;

public interface RelationshipRepository extends CrudRepository<RelationshipModel,Long>{
	
	@Query("MATCH(u:User{userId:$userId}),(m:Menu{itemId:$itemId}) MERGE (u)-[r:ORDERED]->(m)")
	void createRelationhip(Long userId, Long itemId);
	
}
