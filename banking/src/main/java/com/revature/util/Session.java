package com.revature.util;

import com.revature.account.Account;
import com.revature.models.AppUser;
import com.revature.models.UserRole;

import java.sql.Connection;

public class Session {

    private AppUser sessionUser;
    private Connection connection;
    private Account account;

    public Session(AppUser sessionUser, Connection connection) {

        if (sessionUser == null || connection == null) {
            throw new ExceptionInInitializerError("Cannot establish user session, null values provided!");
        }

        this.sessionUser = sessionUser;
        this.connection = connection;


    }

    public AppUser getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(AppUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Account getAccount(){ return account; }

    public void setAccount(Account account){this.account=account;}

    public boolean isAdmin() {
        return (sessionUser.getUserRole().equals(UserRole.ADMIN));
    }

}