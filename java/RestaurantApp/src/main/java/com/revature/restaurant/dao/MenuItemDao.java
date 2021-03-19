package com.revature.restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.restaurant.pojo.MenuItem;

public class MenuItemDao {
	
	List<MenuItem> dummyDB = new ArrayList<MenuItem>();
	
	public MenuItemDao() {
		super();
		dummyDB.add(new MenuItem("Pizza", 12.00));
		dummyDB.add(new MenuItem("Curry", 14.33));
		dummyDB.add(new MenuItem("Pasta", 12.65));
		dummyDB.add(new MenuItem("Lobster", 35.24));
		dummyDB.add(new MenuItem("Mac & Cheese", 7.89));
		dummyDB.add(new MenuItem("French Fries", 3.26));
		dummyDB.add(new MenuItem("Onion Rings", 3.50));
	}

	public List<MenuItem> readAll(){
		return dummyDB;
	}

}
