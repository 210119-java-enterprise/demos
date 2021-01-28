package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.util.Set;

public class UserRepository implements CrudRepository<AppUser>{

    public AppUser findUserByUsername(String string) {
        return null;
    }

    @Override
    public void save(AppUser newObj) {

    }

    @Override
    public Set findAll() {
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public AppUser findById(int id) {
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public boolean update(AppUser updatedObj) {
        System.err.println("Not implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.err.println("Not implemented");
        return false;
    }
}
