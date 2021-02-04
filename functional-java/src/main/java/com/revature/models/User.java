package com.revature.models;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(int i) {
        // included this to see if the compiler is smart enough to deduce with constructor
        // to invoke if using a method reference
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

}