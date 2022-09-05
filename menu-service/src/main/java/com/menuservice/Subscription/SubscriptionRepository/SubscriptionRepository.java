package com.SubscriptionRepository;

import java.util.concurrent.Flow.Subscription;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Integer> {

	Integer getSubscriptionId();

	static void save(SubscriptionRepository subscription) {
		// TODO Auto-generated method stub
		
	}



}

