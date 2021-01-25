package com.revature.models;

import java.util.Objects;

public class AppUser {
    private int id;
    private String fName, lName, username, password;
    private UserRole userRole;

    public AppUser() {
        super();
    }

    public AppUser(AppUser other) {
        this.id = other.id;
        this.fName = other.fName;
        this.lName = other.lName;
        this.username = other.username;
        this.password = other.password;
        this.userRole = other.userRole;
    }

    public AppUser(String fName, String lName, String username, String password) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
    }

    public AppUser(int id, String fName, String lName, String username, String password, UserRole userRole) {
        this(fName, lName, username, password);
        this.id = id;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "AppUser [fName=" + fName + ", id=" + id + ", lName=" + lName + ", password=" + password + ", userRole="
                + userRole + ", username=" + username + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fName, lName, username, password, userRole);
        // final int prime = 31;
        // int result = 1;
        // result = prime * result + ((fName == null) ? 0 : fName.hashCode());
        // result = prime * result + id;
        // result = prime * result + ((lName == null) ? 0 : lName.hashCode());
        // result = prime * result + ((password == null) ? 0 : password.hashCode());
        // result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
        // result = prime * result + ((username == null) ? 0 : username.hashCode());
        // return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AppUser other = (AppUser) obj;
        if (fName == null) {
            if (other.fName != null)
                return false;
        } else if (!fName.equals(other.fName))
            return false;
        if (id != other.id)
            return false;
        if (lName == null) {
            if (other.lName != null)
                return false;
        } else if (!lName.equals(other.lName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userRole != other.userRole)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;

    }

    
}
