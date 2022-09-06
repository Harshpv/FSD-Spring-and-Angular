package com.SubscriptionRepository;



import com.menuservice.Subscription.Model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, Integer> {




}

