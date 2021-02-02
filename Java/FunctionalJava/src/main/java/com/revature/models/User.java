package com.revature.models;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(int i) {
        //Compuler smart enough to know which
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

    public static void main(String[] args) {


    }
}
