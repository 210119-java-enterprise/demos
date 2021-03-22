package com.revature.util;

import java.sql.Connection;

import com.revature.models.AppUser;
import com.revature.models.UserRole;

public class Session {
    
    private AppUser sessionUser;
    private Connection connection;

    public Session(AppUser user, Connection conn) {
        // If either is null, app is a bit broken so might as well throw error
        if (user == null || conn == null) {
            throw new ExceptionInInitializerError("Cannot establish user session, null values provided.");
        }
        sessionUser = user;
        connection = conn;
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

    public boolean isAdmin() {
        return sessionUser.getUserRole().equals(UserRole.ADMIN);
    }

}
