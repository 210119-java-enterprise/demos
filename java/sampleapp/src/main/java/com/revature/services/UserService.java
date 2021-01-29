package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.util.ConnectionFactory;
import com.revature.util.Session;

import static com.revature.SampleApp.app;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public void register(AppUser newUser){
        if(!isUserValid(newUser)) throw new InvalidRequestException("Invalid new user provided");
        if(userDao.findUserByUsername(newUser.getUserName()) != null){
            throw new ResourcePersistenceException("Username is already in use");
        }

        //Design choice, all new users are basic
        newUser.setUserRole(UserRole.BASIC_USER);
        userDao.save(newUser);
    }

    public boolean isUserValid(AppUser user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

    public void authenticate(String username, String password){
        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")){
            throw new InvalidRequestException("Invalid credentials");
        }

        AppUser authUser = userDao.findUserByUsernameAndPassword(username, password);

        if(authUser == null){
            throw new AuthenticationException();
        }

        app().setCurrentSession(new Session(authUser, ConnectionFactory.getInstance().getConnection()));
    }
}
