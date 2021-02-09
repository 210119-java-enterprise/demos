package com.revature.stubs;

import com.revature.models.AppUser;
import com.revature.repos.UserRepository;
import com.revature.util.LinkedList;

import java.util.Optional;

// Hand written class that extends an overwrites the methods of some other class
// for the purpose of creating isolated unit tests
public class UserRepositoryStub extends UserRepository {

    @Override
    public Optional<AppUser> findUserByUsernameAndPassword(String username, String password) {
        return Optional.of(new AppUser());
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return super.findUserByUsername(username);
    }

    @Override
    public void save(AppUser newObj) {
        super.save(newObj);
    }

    @Override
    public LinkedList<AppUser> findAll() {
        return super.findAll();
    }

    @Override
    public AppUser findById(int id) {
        return super.findById(id);
    }

    @Override
    public boolean update(AppUser updatedObj) {
        return super.update(updatedObj);
    }

    @Override
    public boolean deleteById(int id) {
        return super.deleteById(id);
    }
}
