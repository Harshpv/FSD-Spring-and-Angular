package com.menuservice.Subscription.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Menu Already Exists")
public class SubscriptionAlreadyExistsException extends  Exception {
}
