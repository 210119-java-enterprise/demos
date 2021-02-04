package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

/*
    POJO Design Pattern
        - Acronym: "Plain Ol' Java Objects"
        - Design pattern that encapsulates the states and behaviors of a domain object
        - Synonyms: models, entities, beans
        - Characteristics:
            + have private fields/attributes/states
            + has one or more constructors for instantiating the class
            + exposes getters/setters for each private field
            + overrides the Object class's .equals(), .hashcode(), and .toString()
 */
public class Person implements Serializable {

    private int id;
    private String username;
    private String password;
    private Role role;

    public Person() {
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

    // Pre-Java v7 syntax for Object.equals()
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        if (id != person.id) return false;
//        if (username != null ? !username.equals(person.username) : person.username != null) return false;
//        if (password != null ? !password.equals(person.password) : person.password != null) return false;
//        return role == person.role;
//    }


    // Java v7+ syntax for Object.equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(username, person.username) &&
                Objects.equals(password, person.password) &&
                role == person.role;
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (role != null ? role.hashCode() : 0);
//        return result;
//    }

    // Java v7+ syntax for Object.hashcode()
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}