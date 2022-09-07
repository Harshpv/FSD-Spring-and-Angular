package com.menuservice.Subscription.repository;


import com.menuservice.Subscription.model.SubscribedPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribedPlanRepository extends MongoRepository<SubscribedPlan, String> {
}
