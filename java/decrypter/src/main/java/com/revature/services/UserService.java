package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.repos.UserRepository;
import com.revature.util.ConnectionFactory;
import com.revature.util.Session;

import java.sql.Connection;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.revature.Decrypter.app;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credentials provided (null or empty strings)!");
        }


        AppUser authUser = userRepo.findUserByUsernameAndPassword(username, password)
                                    .orElseThrow(AuthenticationException::new);


        app().setCurrentSession(new Session(authUser, ConnectionFactory.getInstance().getConnection()));

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

        Predicate<String> isNullOrEmpty = s -> (s == null || s.trim().equals(""));

        if (isNullOrEmpty.test(user.getUsername())) return false;
        if (isNullOrEmpty.test(user.getPassword())) return false;
        if (isNullOrEmpty.test(user.getFirstName())) return false;
        if (isNullOrEmpty.test(user.getLastName())) return false;

        return true;
    }


}
