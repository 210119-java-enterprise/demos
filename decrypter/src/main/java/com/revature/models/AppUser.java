package com.revature.models;

public class AppUser {


    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private UserRole userRole;

    public AppUser(){
        super();
    }

    public AppUser(AppUser copy){
        this.id=copy.id;
        this.firstname=copy.firstname;
        this.lastname=copy.lastname;
        this.username=copy.username;
        this.password=copy.password;
        this.userRole=copy.userRole;

    }

    public AppUser(String firstname, String lastname,String username, String password, UserRole userRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username= username;
        this.password = password;
        this.userRole = userRole;
    }

    public AppUser(int id, String firstname, String lastname,String username, String password, UserRole userRole) {
       this.(firstname,lastname,username,password);
        this.id = id;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        if (id != appUser.id) return false;
        if (firstname != null ? !firstname.equals(appUser.firstname) : appUser.firstname != null) return false;
        if (lastname != null ? !lastname.equals(appUser.lastname) : appUser.lastname != null) return false;
        if (username != null ? !username.equals(appUser.username) : appUser.username != null) return false;
        if (password != null ? !password.equals(appUser.password) : appUser.password != null) return false;
        return userRole == appUser.userRole;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        return result;
    }
}
