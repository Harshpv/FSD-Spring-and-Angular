//package com.menuservice.Subscription.Service;
//
//import java.util.List;
//import com.menuservice.Subscription.Model.Subscription;
//import javax.imageio.metadata.IIOMetadataFormat;
//
//import com.menuservice.Subscription.SubscriptionRepository.SubscriptionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Subscription.Exception.SubscriptionAlreadyExistsException;
//import com.Subscription.Exception.SubscriptionNotFoundException;
////import com.SubscriptionRepository.SubscriptionRepository;
//
//@Service
//public class SubscriptionServices {
//
//	private final SubscriptionRepository subscriptionrepository;
//	@Autowired
//	public SubscriptionServices(SubscriptionRepository subscriptionrepository) {
//		this.subscriptionrepository = subscriptionrepository;
//
//	}
//
//	//addItems method consists of business logic to add new data to database
//	public void addSubscription(Subscription subscription) throws SubscriptionAlreadyExistsException {
//		subscriptionrepository.save(subscription);
//
//	}
//
//	//update items method conists of business logic to update data altready present in database
//	public String updateSubscription(Subscription subscription) throws SubscriptionNotFoundException{
//		if (subscriptionrepository.existsById(subscription.getSubscriptionId())) {
//			subscriptionrepository.save(subscription);
//			return "update success";
//		}
//		throw new SubscriptionNotFoundException();
//	}
//	//getItems method consists of business logic to fetch all the data present in the database
//		public List<Subscription> getItems() throws SubscriptionNotFoundException {
//
//			if (subscriptionrepository.count() == 0) {
//				throw new SubscriptionNotFoundException();
//			}
//			return subscriptionrepository.findAll();
//
//		}
//
//		//getItemsById method consists of business logic to fetch specific data present in the database using itemId.
//		public Subscription getItemsById(int subscriptionId) throws SubscriptionNotFoundException {
//
//			if (subscriptionrepository.existsById(subscriptionId)) {
//
//				return subscriptionrepository.findById(subscriptionId).get();
//			}
//
//			throw new SubscriptionNotFoundException();
//
//		}
//		//deleteItems method consists of business logic to delete the data present in the database using itemId.
//		public void deleteById(int subscriptionId) throws SubscriptionNotFoundException {
//			if (subscriptionrepository.existsById(subscriptionId)) {
//
//			   subscriptionrepository.deleteById(subscriptionId);
//			}
//
//			throw new SubscriptionNotFoundException();
//		}
//
//
//}
//
//
////	  //update subscription method consists of business logic to update dataalready present in database
////	   public String updateSubscription(Subscription
////	  subscription) throws SubscriptionNotFoundException { if
////	  (SubscriptionRepository.existsById(subscription.getSubscriptionid())) {
////	  subscriptionrepository.save(subscription);
////
////	  return "Update success"; }
////
////	  throw new SubscriptionNotFoundException();
////
////	  } //getsubscription method consists of business logic to fetch all the data
////	  public List<Subscription> get() throws SubscriptionNotFoundException {
////
////	  if (subscriptionrepository.count() == 0) {
////
////		  throw newSubscriptionNotFoundException();
////		  }
////	  return SubscriptionRepository.findAll();
////
////	  //getItemsById method consists of bussiness Logic to fetch specific data
////	  present in the database using item Id
////
////
////	  public Subscription getItemsById(int Subscriptionid)throws
////	  SubscriptionNotFoundException {
////
////	  if (SubscriptionRepository.existsById (Subscriptionid)) {
////
////	  return SubscriptionRepository. findById (Subscriptionid).get();
////
////	  } throw new SubscriptionNotFoundException();
////
////	  } // delete item public void deleteById(int Subscriptionid) throws
////	  SubscriptionNotFoundException{ if
////	  (SubscriptionRepository.existsById(subscriptionId)) {
////
////	  subscriptionRepository.deleteById(subscriptionId).delete(); } throw new
////	  SubscriptionNotFoundException(); }
////
////
////
////
////
////	  }
////
////
////	}
////
