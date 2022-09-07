package com.menuservice.Subscription.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SubscribedPlan")
public class SubscribedPlan {

    @Id
    private String emailId;
    @Indexed(unique = true)

    private String username;
    private String subscriptionTittle;
    private String description;
    private String subscriptionId;
    private double subscriptionPrice;
    private String photo;
    private int validity;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubscriptionTittle() {
        return subscriptionTittle;
    }

    public void setSubscriptionTittle(String subscriptionTittle) {
        this.subscriptionTittle = subscriptionTittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public SubscribedPlan(String emailId, String username, String subscriptionTittle, String description, String subscriptionId, double subscriptionPrice, String photo, int validity) {
        this.emailId = emailId;
        this.username = username;
        this.subscriptionTittle = subscriptionTittle;
        this.description = description;
        this.subscriptionId = subscriptionId;
        this.subscriptionPrice = subscriptionPrice;
        this.photo = photo;
        this.validity = validity;
    }

    public SubscribedPlan() {
        super();
    }

    @Override
    public String toString() {
        return "SubscribedPlan{" +
                "emailId='" + emailId + '\'' +
                ", username='" + username + '\'' +
                ", subscriptionTittle='" + subscriptionTittle + '\'' +
                ", description='" + description + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", subscriptionPrice=" + subscriptionPrice +
                ", photo='" + photo + '\'' +
                ", validity=" + validity +
                '}';
    }
}
