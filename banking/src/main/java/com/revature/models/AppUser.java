package com.revature.models;

import java.util.Objects;

public class AppUser {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserRole userRole;

    public AppUser(){
       super();
    }

    // constructor without id and userRole because people dont sign in with an id and role
    public AppUser(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    //constructor with all properties
    public AppUser(int id, String firstName, String lastName, String username, String password, UserRole userRole) {
        this(firstName, lastName, username, password);
        this.id = id;
        this.userRole = userRole;
    }

    //Setters and getters to set and obtain information from the database

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    //to compare values in objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(username, appUser.username) &&
                Objects.equals(password, appUser.password) &&
                userRole == appUser.userRole;

    }

    // facilitates hash structures like a Map
    public int hashCode() {
       return Objects.hash(id,firstName,lastName,username,password,userRole);
    }

    //returns a given value into string format
    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }


}
