package com.menuservice.Subscription.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Subscription")

public class Subscription {

		@Id
		private String subscriptionId;
		@Indexed(unique = true)

		private int validity;
		private String subscriptionTitle;
		private String description;
		private String photo;
		private double subscriptionPrice;
		List<SubscribedPlan>items;

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getSubscriptionTitle() {
		return subscriptionTitle;
	}

	public void setSubscriptionTitle(String subscriptionTitle) {
		this.subscriptionTitle = subscriptionTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getSubscriptionPrice() {
		return subscriptionPrice;
	}

	public void setSubscriptionPrice(double subscriptionPrice) {
		this.subscriptionPrice = subscriptionPrice;
	}

	public Subscription(String subscriptionId, int validity, String subscriptionTitle, String description, String photo, double subscriptionPrice) {
		this.subscriptionId = subscriptionId;
		this.validity = validity;
		this.subscriptionTitle = subscriptionTitle;
		this.description = description;
		this.photo = photo;
		this.subscriptionPrice = subscriptionPrice;
	}
	public Subscription() {
		super();
	}

	@Override
	public String toString() {
		return "Subscription{" +
				"subscriptionId='" + subscriptionId + '\'' +
				", validity=" + validity +
				", subscriptionTitle='" + subscriptionTitle + '\'' +
				", description='" + description + '\'' +
				", photo='" + photo + '\'' +
				", subscriptionPrice=" + subscriptionPrice +
				", items=" + items +
				'}';
	}
}
