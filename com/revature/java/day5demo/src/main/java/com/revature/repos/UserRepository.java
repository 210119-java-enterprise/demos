package com.revature.repos;

import com.revature.util.Set;

public class UserRepository<AppUser> implements CrudRepository {

    @Override
    public void save(Object newObj) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");

    }

    @Override
    public Set findAll() {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public Object findById(int id) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public boolean update(Object updatedObj) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return false;
    }

    public AppUser findUserByUsername(String username) {
        System.err.println("Not implemented");
        return null;
    }

    
}
