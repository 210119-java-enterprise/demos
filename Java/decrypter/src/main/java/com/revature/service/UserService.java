package com.revature.service;

import com.revature.exceptions.AuthenticationException;
import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.repos.UserRepository;
import com.revature.util.ConnectionFactory;
import com.revature.util.Session;

import static com.revature.Decrypter.app;


public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // Checks if the given user is a valid new user, if it is, saves them and gives them a basic_user role by default
    public void register(AppUser newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException("Invalid new user provided!");

        if (userRepo.findUserByUsername(newUser.getUsername()) != null) {
            throw new ResourcePersistenceException("The provided username is already in use!");
        }

        newUser.setUserRole(UserRole.BASIC_USER);
        userRepo.save(newUser);
    }

    // This Login calls userRepo with the given username and password, and returns true if they are valid
    public boolean validLogin(String username, String password) {
        AppUser appUser = userRepo.findUserByUsername(username);

        return (appUser != null && appUser.getPassword().equals(password));
    }

    // This changes the session variable if given a valid username and password, where userRepo handles the checking\
    // logic.
    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credentials provided (null or empty strings)!");
        }

        AppUser authUser = userRepo.findUserByUsernameAndPassword(username, password)
                                    .orElseThrow(AuthenticationException::new);

        app().setCurrentSession(new Session(authUser, ConnectionFactory.getInstance().getConnection()));
    }

    // checks for non-null and non-empty entries
    public boolean isUserValid(AppUser user) {
        if (user == null ) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}
