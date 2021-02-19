package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.MenuItem;

public class MenuItemRepository {

    List<MenuItem> dummyDB = new ArrayList<MenuItem>();

    public MenuItemRepository() {
        dummyDB.add(new MenuItem("Pizza", 12));
        dummyDB.add(new MenuItem("Curry", 14.33));
        dummyDB.add(new MenuItem("Pasta", 9.5));
        dummyDB.add(new MenuItem("Lobster", 35));
        dummyDB.add(new MenuItem("Mac 'n' Cheese", 3.50));
        dummyDB.add(new MenuItem("Onion Rings", 7.35));
    }

    public List<MenuItem> readAll() {
        return dummyDB;
    }
    
}
