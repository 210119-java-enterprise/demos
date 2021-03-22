package com.revature.service;

import java.util.List;

import com.revature.pojo.MenuItem;
import com.revature.repo.MenuItemRepository;

public class MenuItemService {

    private MenuItemRepository repo;

    public MenuItemService(MenuItemRepository repo) {
        this.repo = repo;
    }

    public List<MenuItem> getAllMenuItems() {
        return repo.readAll();
    }
    
}
