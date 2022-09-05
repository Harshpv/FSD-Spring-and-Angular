package com.Subscription.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Subscription")

public class Subscription {
	
		@Id
		private int subscriptionId;
		@Field
		@Indexed(unique = true)
		
		private int subscrptionvalidity;
		private String subscriptionTitle;
		private String subscriptionDescription;
		private String subscriptionimage;
		private double subscriptionPrice;
		List<SubscribedPlan>items;
		public int getSubscriptionId() {
			return subscriptionId;
		}
		public void setSubscriptionId(int subscriptionId) {
			this.subscriptionId = subscriptionId;
		}
		public int getSubscrptionvalidity() {
			return subscrptionvalidity;
		}
		public void setSubscrptionvalidity(int subscrptionvalidity) {
			this.subscrptionvalidity = subscrptionvalidity;
		}
		public String getSubscriptionTitle() {
			return subscriptionTitle;
		}
		public void setSubscriptionTitle(String subscriptionTitle) {
			this.subscriptionTitle = subscriptionTitle;
		}
		public String getSubscriptionDescription() {
			return subscriptionDescription;
		}
		public void setSubscriptionDescription(String subscriptionDescription) {
			this.subscriptionDescription = subscriptionDescription;
		}
		public String getSubscriptionimage() {
			return subscriptionimage;
		}
		public void setSubscriptionimage(String subscriptionimage) {
			this.subscriptionimage = subscriptionimage;
		}
		public double getSubscriptionPrice() {
			return subscriptionPrice;
		}
		public void setSubscriptionPrice(double subscriptionPrice) {
			this.subscriptionPrice = subscriptionPrice;
		}
		public Subscription(int subscriptionId, int subscrptionvalidity, String subscriptionTitle,
				String subscriptionDescription, String subscriptionimage, double subscriptionPrice) {
			super();
			this.subscriptionId = subscriptionId;
			this.subscrptionvalidity = subscrptionvalidity;
			this.subscriptionTitle = subscriptionTitle;
			this.subscriptionDescription = subscriptionDescription;
			this.subscriptionimage = subscriptionimage;
			this.subscriptionPrice = subscriptionPrice;
		}
		public Subscription() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Subscription [subscriptionId=" + subscriptionId + ", subscrptionvalidity=" + subscrptionvalidity
					+ ", subscriptionTitle=" + subscriptionTitle + ", subscriptionDescription="
					+ subscriptionDescription + ", subscriptionimage=" + subscriptionimage + ", subscriptionPrice="
					+ subscriptionPrice + "]";
		}
		
		
		
		
}
