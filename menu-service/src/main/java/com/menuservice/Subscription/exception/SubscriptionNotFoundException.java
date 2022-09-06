package com.menuservice.Subscription.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;


@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Subscription Not Found")

public class SubscriptionNotFoundException extends Exception{

}
