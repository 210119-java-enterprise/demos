package com.revature.models;

import java.util.Objects;

/*
POJO Design pattern  -- Plain Old Java Objects
    -design pattern that encapsulates the states and behaviours of a domain object
    -Synonyms: models, entities, beans
    -characteristics:
        -have private fields/attributes/states
        -has one or more constructors for instantiating the class
        -exposes getters/setters for each private field
        -overrides the Objects class's .equals() .hashcode() and .toString()
 */
public class Person {
    private int id;
    private String username;
    private String password;
    private Role role;

    public Person(){
        super();
    }

    public Person(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Person(int id, String username, String password, Role role) {
        this(username, password, role);
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(username, person.username) && Objects.equals(password, person.password) && role == person.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }

    @Override
    public String toString(){
        return "im a people";
    }
}
