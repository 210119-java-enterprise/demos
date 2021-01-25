package com.revature.models;

import java.util.Objects;

public class AppUser {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    private String passWord;
    private UserRole userRole;

    public AppUser() {
        super();
    }

    public AppUser(AppUser copy) {
        this.id = copy.id;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.userName = copy.userName;
        this.passWord = copy.passWord;
        this.userRole = copy.userRole;
    }

    public AppUser(int id, String firstName, String lastName, String userName, String passWord, UserRole userRole) {
        this(firstName, lastName, userName, passWord);
        this.id = id;
        this.userRole = userRole;
    }

    public AppUser(String firstName, String lastName, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userRole=" + userRole +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id && firstName.equals(appUser.firstName) && lastName.equals(appUser.lastName) && userName.equals(appUser.userName) && passWord.equals(appUser.passWord) && userRole == appUser.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, passWord, userRole);
    }
}
