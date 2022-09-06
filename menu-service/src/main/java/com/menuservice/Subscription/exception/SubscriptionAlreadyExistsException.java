package com.menuservice.Subscription.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Subscription Already Exists")
public class SubscriptionAlreadyExistsException  extends Exception{

	
}
