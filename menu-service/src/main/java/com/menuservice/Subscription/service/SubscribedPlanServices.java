package com.menuservice.Subscription.service;



import com.menuservice.Subscription.exception.SubscriptionAlreadyExistsException;
import com.menuservice.Subscription.exception.SubscriptionNotFoundException;
import com.menuservice.Subscription.model.SubscribedPlan;
import com.menuservice.Subscription.repository.SubscribedPlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubscribedPlanServices {

    SubscribedPlanRepository subscribedPlanRepository;

    public SubscribedPlanServices(SubscribedPlanRepository subscribedPlanRepository) {
        super();
        this.subscribedPlanRepository = subscribedPlanRepository;
    }
//addsubscription method consists of business logic to add new data to database
    public void addSubscribedPlan(SubscribedPlan subscribedPlan) throws SubscriptionAlreadyExistsException {
        if (subscribedPlanRepository.existsById(subscribedPlan.getEmailId())) {
            throw new SubscriptionAlreadyExistsException();
        }
        subscribedPlanRepository.insert(subscribedPlan);
    }
//get subscription method consists of business logic to fetch all the data already present in database
    public List<SubscribedPlan> getSubscribedPlan() throws SubscriptionAlreadyExistsException, SubscriptionNotFoundException {
        if (subscribedPlanRepository.findAll().isEmpty()) {
            throw new SubscriptionNotFoundException();
        }
        return subscribedPlanRepository.findAll();
    }
// method is used to check the the subscriptionplan with the Id
    public SubscribedPlan getSubscribedPlanById(String emailId) throws SubscriptionNotFoundException{
        if (subscribedPlanRepository.findById(emailId).isPresent()){
            return subscribedPlanRepository.findById(emailId).get();
        }
        else{
            throw new SubscriptionNotFoundException();
        }
    }
    public void deleteBySubscribedPlanById(String emailId) throws SubscriptionNotFoundException{
        if(subscribedPlanRepository.findById(emailId).isPresent()){
            subscribedPlanRepository.deleteById(emailId);
        }
        else{
            throw new SubscriptionNotFoundException();
        }
    }

    public void updateSubscribedPlan(SubscribedPlan subscribedPlan) throws SubscriptionNotFoundException{
        if (subscribedPlanRepository.findById(subscribedPlan.getEmailId()).isEmpty()){
            throw new SubscriptionNotFoundException();
        }
        subscribedPlanRepository.save(subscribedPlan);
    }

}
