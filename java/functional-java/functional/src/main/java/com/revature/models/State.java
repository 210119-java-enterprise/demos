package com.revature.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {
    private String name;
    private List<User> stateUsers;

    public State(String name, User... stateUsers) {
        this.name = name;
        this.stateUsers = new ArrayList<>(Arrays.asList(stateUsers));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getStateUsers() {
        return stateUsers;
    }

    @Override
    public String toString() {
        return "State [name=" + name + ", stateUsers=" + stateUsers + "]";
    }

    
    
}
