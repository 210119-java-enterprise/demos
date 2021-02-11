package com.revature.model;

import java.util.List;

public class User {
    private int id;
    public String username;
    public String password;
    public List<String> features;

    public User() {
    }

    public User(int id, String username, String password, List<String> features) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.features = features;
    }

}
