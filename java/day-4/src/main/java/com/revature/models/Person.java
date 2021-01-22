package com.revature.models;

import java.util.Arrays;
import java.util.Objects;

/**
 * DOJO Design pattern
 * -design pattern that encapsulates the states and behaviors of a domain object
 * -synonyms: models, entities, beans
 * -characteristics: have private fields/attributes/state
 *                   has one or more constructors for instantiating the class
 *                   exposes getters/setters for each private field
 *                   overrides the object class's .equals(), .hashcode(), and .toString()
 */

public class Person {

    private int id;
    private String username;
    private String password;
    private Role roles; //enum tpye of role with specific roles or values

    public Person(){

    }

    public Person(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Person(int id, String username, String password, Role roles) {
        this(id, username, password);
        this.roles = roles;
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

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(username, person.username) && Objects.equals(password, person.password) && roles == person.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roles);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
