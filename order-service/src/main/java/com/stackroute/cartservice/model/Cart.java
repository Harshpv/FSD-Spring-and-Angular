package com.stackroute.cartservice.model;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;



@Data

@Document(collection = "carts")
public class Cart {

	@Id
	private @NonNull String userEmailId;


	private @NonNull List<Menu> items;


}
	
	

 
	



		




