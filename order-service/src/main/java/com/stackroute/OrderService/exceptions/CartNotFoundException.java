package com.stackroute.OrderService.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;


@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Cart Not Found")
public class CartNotFoundException extends Exception {

}

