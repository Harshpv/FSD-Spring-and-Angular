package com.recommendationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.model.Menu;
import com.recommendationservice.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;

	public List<Menu> getAllMenu() {
		return menuRepository.getAllMenu();
	}

	public void addMenu(Menu menu) {
		menuRepository.save(menu);
	}

	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);
	}

	public void deleteMenu(Long userId) {
		menuRepository.deleteById(userId);
	}
}
