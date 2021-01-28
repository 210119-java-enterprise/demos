package com.revature.dao;

import com.revature.models.AppUser;
import com.revature.util.Set;

public class UserDao implements CrudDao<AppUser> {

    public AppUser findUserByUsername(String username){
        System.err.println("not implemented");
        return null;
    }

    @Override
    public void save(AppUser newObj) {
        System.err.println("not implemented");

    }

    @Override
    public Set<AppUser> findAll() {
        System.err.println("not implemented");
        return null;
    }

    @Override
    public AppUser findById(int id) {
        System.err.println("not implemented");
        return null;
    }

    @Override
    public boolean update(AppUser updObj) {
        System.err.println("not implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.err.println("not implemented");
        return false;
    }
}
