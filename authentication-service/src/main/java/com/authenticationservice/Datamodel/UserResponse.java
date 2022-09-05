package com.authenticationservice.Datamodel;

import java.io.Serializable;

public class UserResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	
	private String jwt;

	public UserResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	
} 
