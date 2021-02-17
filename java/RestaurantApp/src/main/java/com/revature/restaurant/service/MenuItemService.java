package com.revature.restaurant.service;

import java.util.List;

import com.revature.restaurant.dao.MenuItemDao;
import com.revature.restaurant.pojo.MenuItem;

public class MenuItemService {
	
	private MenuItemDao dao;
	
	public MenuItemService(MenuItemDao dao) {
		super();
		this.dao = dao;
	}

	public List<MenuItem> getAllMenuItems(){
		return dao.readAll();
	}

}
