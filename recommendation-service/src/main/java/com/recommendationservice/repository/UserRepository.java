package com.recommendationservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.recommendationservice.model.Menu;
import com.recommendationservice.model.User;

public interface UserRepository extends Neo4jRepository<User, Long>{
	
	@Query("MATCH (n:User) RETURN (n)")
	List<User> getAllUsers();
	
	@Query("MATCH (n:User{id:$id}) RETURN (n)")
	User findByUserId(Long id);
	
	@Query("MATCH (m:Menu) RETURN (m)")
	List<Menu> suggestByCity(String city);
	

}
