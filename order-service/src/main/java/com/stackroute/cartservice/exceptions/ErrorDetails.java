package com.stackroute.cartservice.exceptions;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date date, String message, String description) {
		this.timestamp=date;
		this.message=message;
		this.details=description;
	}
<<<<<<< HEAD
=======

>>>>>>> 65d5bb22656b3c9768134d7de5eca1f310d778eb
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
