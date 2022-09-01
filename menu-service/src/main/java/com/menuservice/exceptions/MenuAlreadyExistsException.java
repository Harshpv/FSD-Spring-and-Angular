package com.menuservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Menu Already Exists")
public class MenuAlreadyExistsException extends Exception{

}
