package com.revature.models;

import java.util.Objects;

public class AppUser {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private UserRole userRole;

    public AppUser(){
        super();
    }

    /**
     * This constructor is to easily make a copy of a user
     * @param copy the AppUser that is going to be copied
     */
    public AppUser(AppUser copy){
        this.id = copy.id;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.userName = copy.userName;
        this.password = copy.password;
        this.userRole = copy.userRole;
    }

    public AppUser(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public AppUser(int id, String firstName, String lastName, String userName, String password, UserRole userRole) {
        this(firstName, lastName, userName, password);
        this.id = id;
        this.userRole = userRole;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && Objects.equals(firstName, appUser.firstName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(userName, appUser.userName) && Objects.equals(password, appUser.password) && userRole == appUser.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, password, userRole);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
