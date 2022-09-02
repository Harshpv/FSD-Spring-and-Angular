package com.menuservice.datamodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="menuitems")
public class MenuModel {
	

	
	@Id
	private int itemId;
	@Field(name="name")
	@Indexed(unique = true)
	private String itemName;
	@Field(name="description")
	private String itemDescription;
	@Field(name="category")
	private String category;
	@Field(name="cost")
	private long itemCost;
	@Field(name="image")
	private String itemImage;

	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
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
	public MenuModel(int itemId, String itemName, String itemDescription, String category, long itemCost,String itemImage) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.category = category;
		this.itemCost = itemCost;
		this.itemImage=itemImage;
	}
	public MenuModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MenuModel [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", category=" + category + ", itemCost=" + itemCost + ", itemImage=" +" itemImage + ]";
	}


	
}
