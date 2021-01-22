package com.revature.models;

import java.util.Objects;

/*Pojo design pattern
    - "Plain Ol' Java Objects"
    - design pattern that encapsulates the states and behaviors of a domain object
    - Synonyms: models, entities, beans
    - Characteristics
        - have private fields/attributes/states
        - one or more constructors for instantiating the class
        - exposes getters/setters for each private field
        - overrides the object class's .equals(), .hashcode(), and .toString()
 */
public class Person {
    private int id;
    private String username;
    private String password;
    private Role role;


    public Person() {
        super();
    }

    public Person(int id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

/*
Java enums
    enumerated types
    used to define a collection of constant values
    constructtors of enums are alwasy private

public enum Role{
    ADMIN, DEV, TRAINER, QC_ANALYST, BLDG_MNGR, SITE_MGNR


}
 */

