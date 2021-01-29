package com.revature.services;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    public AppUser login(String username, String password) {
        AppUser user;

        if (userRepo.findUserByUsernameAndPassword(username, password) != null) {
           user=userRepo.findUserByUsernameAndPassword(username, password);
            return user;
        }
        System.out.println("Invalid Credentials");
        
        return null;//  TODO NULL is BAD

    }


    public void register(AppUser newUser) {

        if (!isUserValid(newUser)){
            throw new InvalidRequestException("Invalid new user provided!");
        }

        if (userRepo.findUserByUsername(newUser.getUsername()) != null) {
            throw new ResourcePersistenceException("The provided username is already in use!");
        }

        newUser.setUserRole(UserRole.BASIC_USER);
        userRepo.save(newUser);

    }

    public boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }


}
