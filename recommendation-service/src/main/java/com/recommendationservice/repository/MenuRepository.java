package com.recommendationservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.recommendationservice.model.Menu;
import com.recommendationservice.model.User;

public interface MenuRepository extends Neo4jRepository<Menu, Long>{
	@Query("MATCH (n:Menu) RETURN (n)")
	List<Menu> getAllMenu();
	
	
}
