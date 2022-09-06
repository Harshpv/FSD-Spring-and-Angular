package com.menuservice.Subscription.Controller;

import com.menuservice.Subscription.Exception.SubscriptionAlreadyExistsException;
import com.menuservice.Subscription.Exception.SubscriptionNotFoundException;
import com.menuservice.Subscription.Model.Subscription;
import com.menuservice.Subscription.Service.SubscriptionServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController

@RequestMapping("/api/v1/Subscription") 

public class SubscriptionController {
	
	//callig services
private SubscriptionServices services;

//calling subscriptionmodel class and creating object to use further 
@Autowired
public SubscriptionController(SubscriptionServices services) {
	this.services = services;
}

//postmapping is used to post data into database
@PostMapping
public ResponseEntity<Object> addItemsToSubscription(@RequestBody Subscription subscription) {
try {
	services.addSubscription(subscription);
	return new ResponseEntity<>("subscription added succesfully",HttpStatus.CREATED);
} catch (SubscriptionAlreadyExistsException e) {

	return new ResponseEntity<>("Subscription  already exists!!",HttpStatus.CONFLICT);
} catch (Exception e) {
	return new ResponseEntity<>("Subscription details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
}


}

//Putmapping api used to update data which already exists in the mongo database. 
	@PutMapping //("/{subscriptionId}")
	public ResponseEntity<Object> saveOrUpdate(@RequestBody Subscription subscription) {
		try {

			services.updateSubscription(subscription);
			return new ResponseEntity<>("Update success!!", HttpStatus.OK);

		} catch (SubscriptionNotFoundException e) {

			return new ResponseEntity<>("Subscription not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}
	//Getmapping api used to fetch all the data  present in the mongo database. 
		@GetMapping
		public ResponseEntity<Object> getItems() {
			try {
				return ResponseEntity.ok(services.getItems());
			} catch (SubscriptionNotFoundException e) {
				return new ResponseEntity<Object>("Empty repository!!", HttpStatus.CONFLICT);
			}
		}

		//Getmapping  api with id used to fetch specific data with it's id, present in the mongo database.
		@GetMapping("/{subscriptionId}")
		public org.springframework.http.ResponseEntity<Object> getItemsById(@PathVariable int SubscriptionId) {

			try {

				return new ResponseEntity<Object>(services.getItemsById(SubscriptionId), HttpStatus.OK);

			} catch (SubscriptionNotFoundException e) {

				return new ResponseEntity<Object>("Subscription not found!!", HttpStatus.CONFLICT);
			} catch (Exception e) {

				return new ResponseEntity<Object>("Subscription not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

		//Deletemapping api with id used to delete specific data with it's id, present in the mongo database
		@SuppressWarnings("unchecked")
		@DeleteMapping("/{SubscriptionId}")
		public ResponseEntity<?> deleteItem(@PathVariable int SubscriptionId) {
			try {

				services.deleteById(SubscriptionId);
				return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);

			} catch (SubscriptionNotFoundException e) { 

				

				return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
			} catch (Exception e) {

				return new ResponseEntity<>("Something went wrong!!", HttpStatus.INTERNAL_SERVER_ERROR);

			}

		}
		
}

	
	
//	
//	return new ResponseEntity<>
//("subscribed",
//HttpStatus.INTERNAL_SERVER_ERROR); } }
//
//@GetMapping("/{subscriptionid"}) public ResponseEntity <model>
//getsubscriptionByid(@PathVariable int subscriptionid) { try { return new
//ResponseEntity<>(services.getSubscriptionByid(subscriptionid),
//HttpStatus.ok); }catch (NotSubscribedException e) { return new
//ResponseEntity("not subscribed!!", HttpStatus.CONFLICT); }catch (Exception e)
//{ return new ResponseEntity("not subscribed!!",
//HttpStatus.INTERNAL_SERVER_ERROR); }
//
//
//
//@DeleteMapping("/{SubscriptionId}") public void
//deleteSubscription(@Pathvariablle int subscriptionid) { try {
//this.subscriptionservices.deleteById(subscriptionid); }catch
//(NotSubscribedException e) {
//
//}
//
//}
//
//
//
//
//
//}
//
