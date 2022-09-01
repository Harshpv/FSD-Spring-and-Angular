package com.menuservice.datamodel;

import javax.annotation.Generated;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.Nullable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection="menuitems")

public class MenuModel {
	
//	@Transient
//	public static final String SEQUENCE_NAME="item_sequence";
	
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
//	private Binary itemImage;

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
	public MenuModel(int itemId, String itemName, String itemDescription, String category, long itemCost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.category = category;
		this.itemCost = itemCost;
	}
	public MenuModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MenuModel [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", category=" + category + ", itemCost=" + itemCost + "]";
	}


	
}
