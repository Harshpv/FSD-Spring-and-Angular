package com.menuservice.services;

import java.util.List;

import javax.imageio.metadata.IIOMetadataFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuservice.datamodel.MenuModel;
import com.menuservice.exceptions.MenuAlreadyExistsException;
import com.menuservice.exceptions.MenuNotFoundException;
//import com.menuservice.datamodel.MenuSequence;
import com.menuservice.repository.MenuRepository;

@Service
public class Services {
	
	//Calling menurepository to use in creating wanted service.
	@Autowired
	private final MenuRepository menuRepository;

	@SuppressWarnings("unused")
	private MenuModel menuModel;

	public Services(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;

	}

	//addItems method consists of business logic to add new data to database
	public void addItems(MenuModel menuModel) throws MenuAlreadyExistsException {

		menuRepository.insert(menuModel);

	}

	//updateItems method consists of business logic to update data already present in  database
	public String updateItem(MenuModel menuModel) throws MenuNotFoundException {
//			boolean found=false;
//		MenuModel savedMenuModel = menuRepository.findById(menuModel.getItemId()).get();
		
//		if (menuRepository.existsById(menuModel.getItemId())) {
//		 if(savedMenuModel.getItemId()==menuModel.getItemId()) {
//			found=true;
//			savedMenuModel.setItemId(menuModel.getItemId());
//			savedMenuModel.setItemName(menuModel.getItemName());
//			savedMenuModel.setItemDescription(menuModel.getItemDescription());
//			savedMenuModel.setCategory(menuModel.getCategory());
//			savedMenuModel.setItemCost(menuModel.getItemCost());

		    
		     if (menuRepository.existsById(menuModel.getItemId())) {
		    	 menuRepository.save(menuModel);
		    	 
		    	 return "Update success";
			}
		     
		     throw new MenuNotFoundException();

		
}

	//getItems method consists of business logic to fetch all the data present in the database
	public List<MenuModel> getItems() throws MenuNotFoundException {

		if (menuRepository.count() == 0) {
			throw new MenuNotFoundException();
		}
		return menuRepository.findAll();

	}
	//getItemsById method consists of business logic to fetch specific data present in the database using itemId.
	public MenuModel getItemsById(int itemId) throws MenuNotFoundException {

		if (menuRepository.existsById(itemId)) {

			return menuRepository.findById(itemId).get();
		}

		throw new MenuNotFoundException();

	}
	//deleteItems method consists of business logic to delete the data present in the database using itemId.
	public void deleteById(int itemId) throws MenuNotFoundException {
		if (menuRepository.existsById(itemId)) {

		   menuRepository.deleteById(itemId);
		}

		throw new MenuNotFoundException();
	}

}
