package com.revature.services;

import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.repos.UserRepository;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    public void register(AppUser newUser) {
        if (!isUserValid(newUser))
            throw new InvalidRequestException("Invalid new user provided");

        if (userRepo.findUserByUsername(newUser.getUsername()) != null) 
            throw new ResourcePersistenceException("Provided username already in use");

        newUser.setUserRole(UserRole.BASIC_USER);
        userRepo.save(newUser);
    }

    // AppUser must have non-null first name, last name, username, password
    private boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getfName() == null || user.getfName().trim().equals(""))
            return false;
        if (user.getlName() == null || user.getlName().trim().equals(""))
            return false;
        if (user.getUsername() == null || user.getUsername().trim().equals(""))
            return false;
        if (user.getPassword() == null || user.getPassword().trim().equals(""))
            return false;
        return true;
    }
}
