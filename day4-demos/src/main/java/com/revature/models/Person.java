package com.revature.models;

import java.util.Objects;

/*
*  POJO Design Pattern
*   "Plan Ol' Java Objects"
*   -Design pattern that encapsulates the states and behaviors of a domain object
*   - Synonyms: models, entities, beans
*   - Characteristics:
*       + have private fields/attributes/states
*       + has one or more constructors for instantiating the class
*       + exposes getters/setters for each private field
*       + overrides the Object class's .equals(), .hascode(), and .toString()
*
*
*
* */
public class Person {

    private int id;
    private String username;
    private String password;
    private Role roles;

    public Person()
    {
        super();
    }

    public Person(String username, String password, Role roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Person(int id, String username, String password, Role roles) {
        this(username, password, roles);
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
