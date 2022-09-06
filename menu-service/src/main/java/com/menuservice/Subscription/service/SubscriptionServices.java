package com.menuservice.Subscription.service;

import com.menuservice.Subscription.exception.SubscriptionAlreadyExistsException;
import com.menuservice.Subscription.exception.SubscriptionNotFoundException;
import com.menuservice.Subscription.model.Subscription;
import com.menuservice.Subscription.repository.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubscriptionServices {

	SubscriptionRepository subscriptionrepository;

	public SubscriptionServices(SubscriptionRepository subscriptionrepository) {
		this.subscriptionrepository = subscriptionrepository;

	}

	//addItems method consists of business logic to add new data to database
	public void addSubscription(Subscription subscription) throws SubscriptionAlreadyExistsException {
		subscriptionrepository.save(subscription);

	}

	//update Subscription method conists of business logic to update data altready present in database
	public String updateSubscription(Subscription subscription) throws SubscriptionNotFoundException {
		if (subscriptionrepository.existsById(subscription.getSubscriptionId())) {
			subscriptionrepository.save(subscription);
			return "update success";
		}
		throw new SubscriptionNotFoundException();
	}
	//getsubscription method consists of business logic to fetch all the data present in the database
		public List<Subscription> getItems() throws SubscriptionNotFoundException {

			if (subscriptionrepository.count() == 0) {
				throw new SubscriptionNotFoundException();
			}
			return subscriptionrepository.findAll();

		}

		//getSubscriptionById method consists of business logic to fetch specific data present in the database using itemId.
		public Subscription getItemsById(int subscriptionId) throws SubscriptionNotFoundException {

			if (subscriptionrepository.existsById(subscriptionId)) {

				return subscriptionrepository.findById(subscriptionId).get();
			}

			throw new SubscriptionNotFoundException();

		}
		//deleteSubscription method consists of business logic to delete the data present in the database using itemId.
		public void deleteById(int subscriptionId) throws SubscriptionNotFoundException {
			if (subscriptionrepository.existsById(subscriptionId)) {

			   subscriptionrepository.deleteById(subscriptionId);
			}

			throw new SubscriptionNotFoundException();
		}


}
	
	
//	  //update subscription method consists of business logic to update dataalready present in database
//	   public String updateSubscription(Subscription
//	  subscription) throws SubscriptionNotFoundException { if
//	  (SubscriptionRepository.existsById(subscription.getSubscriptionid())) {
//	  subscriptionrepository.save(subscription);
//	  
//	  return "Update success"; }
//	  
//	  throw new SubscriptionNotFoundException();
//	  
//	  } //getsubscription method consists of business logic to fetch all the data
//	  public List<Subscription> get() throws SubscriptionNotFoundException {
//	  
//	  if (subscriptionrepository.count() == 0) { 
//		  
//		  throw newSubscriptionNotFoundException(); 
//		  } 
//	  return SubscriptionRepository.findAll();
//	  
//	  //getItemsById method consists of bussiness Logic to fetch specific data
//	  present in the database using item Id
//	  
//	  
//	  public Subscription getItemsById(int Subscriptionid)throws
//	  SubscriptionNotFoundException {
//	  
//	  if (SubscriptionRepository.existsById (Subscriptionid)) {
//	  
//	  return SubscriptionRepository. findById (Subscriptionid).get();
//	  
//	  } throw new SubscriptionNotFoundException();
//	  
//	  } // delete item public void deleteById(int Subscriptionid) throws
//	  SubscriptionNotFoundException{ if
//	  (SubscriptionRepository.existsById(subscriptionId)) {
//	  
//	  subscriptionRepository.deleteById(subscriptionId).delete(); } throw new
//	  SubscriptionNotFoundException(); }
//	  
//	  
//	  
//	  
//	  
//	  }
//	 
//		
//	}
//
