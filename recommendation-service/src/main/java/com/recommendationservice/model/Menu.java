package com.recommendationservice.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Menu {
	@Id
	private Long itemId;
	String itemName;
	String itemDescription;
	String category;
	long itemCost;
	byte[] image;
	boolean silver;
	boolean gold;
	boolean platinum;
	public Menu(Long itemId, String itemName, String itemDescription, String category, long itemCost, byte[] image,
			boolean silver, boolean gold, boolean platinum) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.category = category;
		this.itemCost = itemCost;
		this.image = image;
		this.silver = silver;
		this.gold = gold;
		this.platinum = platinum;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getItemCost() {
		return itemCost;
	}
	public void setItemCost(long itemCost) {
		this.itemCost = itemCost;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public boolean isSilver() {
		return silver;
	}
	public void setSilver(boolean silver) {
		this.silver = silver;
	}
	public boolean isGold() {
		return gold;
	}
	public void setGold(boolean gold) {
		this.gold = gold;
	}
	public boolean isPlatinum() {
		return platinum;
	}
	public void setPlatinum(boolean platinum) {
		this.platinum = platinum;
	}
	
	
}
