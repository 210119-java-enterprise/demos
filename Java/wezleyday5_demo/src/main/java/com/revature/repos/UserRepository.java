package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.util.Set;

public class UserRepository implements CrudRepository<AppUser> {

    public AppUser findUserByUsername(String username) {
        System.err.println("Not Implemented");
        return null;
    }

    @Override
    public void save(AppUser newObj) {
        System.err.println("Not Implemented");
    }

    @Override
    public Set<AppUser> findAll() {
        System.err.println("Not Implemented");
        return null;
    }

    @Override
    public AppUser findById(int id) {
        System.err.println("Not Implemented");
        return null;
    }

    @Override
    public boolean update(AppUser updatedObj) {
        System.err.println("Not Implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.err.println("Not Implemented");
        return false;
    }
}
