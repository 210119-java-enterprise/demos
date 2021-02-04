package com.revature.model;

import com.revature.annotations.Ignore;

import java.util.List;
import java.util.Objects;

public class User {

    private int id;
    private String username;
    private String password;
    private List<String> features;

    public User() {
        super();
    }

    protected User(int id) {
        this.id = id;
    }

    public User(int id, String username, String password, List<String> features) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Ignore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(features, user.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, features);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", features=" + features +
                '}';
    }

}
