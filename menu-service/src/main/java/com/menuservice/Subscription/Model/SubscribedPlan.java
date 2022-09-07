//package com.Subscription.Model;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//public class SubscribedPlan {
//
//	@Id
//	private int emailId;
//	@Field
//	@Indexed(unique = true)
//	private String userName;
//	private String subscriptionTitle;
//	private String subscriptionDescription;
//	private String subscriptionId;
//	private String subscriptionImage;
//	private double subscriptionPrice;
//	private int subscriptionValidity;
//	private double localDate;
//	private double purchaseDate;
//	public int getEmailId() {
//		return emailId;
//	}
//	public void setEmailId(int emailId) {
//		this.emailId = emailId;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getSubscriptionTitle() {
//		return subscriptionTitle;
//	}
//	public void setSubscriptionTitle(String subscriptionTitle) {
//		this.subscriptionTitle = subscriptionTitle;
//	}
//	public String getSubscriptionDescription() {
//		return subscriptionDescription;
//	}
//	public void setSubscriptionDescription(String subscriptionDescription) {
//		this.subscriptionDescription = subscriptionDescription;
//	}
//	public String getSubscriptionId() {
//		return subscriptionId;
//	}
//	public void setSubscriptionId(String subscriptionId) {
//		this.subscriptionId = subscriptionId;
//	}
//	public String getSubscriptionImage() {
//		return subscriptionImage;
//	}
//	public void setSubscriptionImage(String subscriptionImage) {
//		this.subscriptionImage = subscriptionImage;
//	}
//	public double getSubscriptionPrice() {
//		return subscriptionPrice;
//	}
//	public void setSubscriptionPrice(double subscriptionPrice) {
//		this.subscriptionPrice = subscriptionPrice;
//	}
//	public int getSubscriptionValidity() {
//		return subscriptionValidity;
//	}
//	public void setSubscriptionValidity(int subscriptionValidity) {
//		this.subscriptionValidity = subscriptionValidity;
//	}
//	public double getLocalDate() {
//		return localDate;
//	}
//	public void setLocalDate(double localDate) {
//		this.localDate = localDate;
//	}
//	public double getPurchaseDate() {
//		return purchaseDate;
//	}
//	public void setPurchaseDate(double purchaseDate) {
//		this.purchaseDate = purchaseDate;
//	}
//	public SubscribedPlan(int emailId, String userName, String subscriptionTitle, String subscriptionDescription,
//			String subscriptionId, String subscriptionImage, double subscriptionPrice, int subscriptionValidity,
//			double localDate, double purchaseDate) {
//		super();
//		this.emailId = emailId;
//		this.userName = userName;
//		this.subscriptionTitle = subscriptionTitle;
//		this.subscriptionDescription = subscriptionDescription;
//		this.subscriptionId = subscriptionId;
//		this.subscriptionImage = subscriptionImage;
//		this.subscriptionPrice = subscriptionPrice;
//		this.subscriptionValidity = subscriptionValidity;
//		this.localDate = localDate;
//		this.purchaseDate = purchaseDate;
//	}
//	public SubscribedPlan() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public String toString() {
//		return "SubscribedPlan [emailId=" + emailId + ", userName=" + userName + ", subscriptionTitle="
//				+ subscriptionTitle + ", subscriptionDescription=" + subscriptionDescription + ", subscriptionId="
//				+ subscriptionId + ", subscriptionImage=" + subscriptionImage + ", subscriptionPrice="
//				+ subscriptionPrice + ", subscriptionValidity=" + subscriptionValidity + ", localDate=" + localDate
//				+ ", purchaseDate=" + purchaseDate + "]";
//	}
//
//
//
//
//}
