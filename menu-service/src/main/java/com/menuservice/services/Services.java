package com.menuservice.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.menuservice.datamodel.MenuModel;
import com.menuservice.exceptions.MenuAlreadyExistsException;
import com.menuservice.exceptions.MenuNotFoundException;
//import com.menuservice.datamodel.MenuSequence;
import com.menuservice.repository.MenuRepository;

@Service
public class Services {

	private final MenuRepository menuRepository;

	private MenuModel menuModel;

	public Services(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;

	}

	public void addItems(MenuModel menuModel) throws MenuAlreadyExistsException {

		menuRepository.insert(menuModel);

	}

	public MenuModel updateItem(MenuModel menuModel) throws MenuNotFoundException {

		MenuModel savedMenuModel = menuRepository.findById(menuModel.getItemId()).get();
		if (menuRepository.existsById(menuModel.getItemId())) {

			savedMenuModel.setItemId(menuModel.getItemId());
			savedMenuModel.setItemName(menuModel.getItemName());
			savedMenuModel.setItemDescription(menuModel.getItemDescription());
			savedMenuModel.setCategory(menuModel.getCategory());
			savedMenuModel.setItemCost(menuModel.getItemCost());

			return menuRepository.save(menuModel);

		}

		throw new MenuNotFoundException();
	}

	public List<MenuModel> getItems() throws MenuNotFoundException {

		if (menuRepository.count() == 0) {
			throw new MenuNotFoundException();
		}
		return menuRepository.findAll();

	}

	public MenuModel getItemsById(int itemId) throws MenuNotFoundException {

		if (menuRepository.existsById(itemId)) {

			return menuRepository.findById(itemId).get();
		}

		throw new MenuNotFoundException();

	}

	public void deleteById(int itemId) throws MenuNotFoundException {
		if (menuRepository.existsById(itemId)) {

			menuRepository.deleteById(itemId);
		}

		throw new MenuNotFoundException();
	}

}
