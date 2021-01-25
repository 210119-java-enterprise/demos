package com.revature.models;

import java.util.Objects;

//POJO design pattern
    // Design pattern that encapsulates states and behaviors of a domain object
    // Synonyms: models, entities, beans
    // POGO is a way to make classes to be specific
        //Private fields and attributes, one or more constructors for instantiating class, exposes getters/setters
        //overrides object classes .equals, .hashcode and .tostring
public class Person {

    private int id;
    private String userName;
    private String password;
    private Role roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(userName, person.userName) && Objects.equals(password, person.password) && roles == person.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, roles);
    }

    public Person(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Person(int id, String userName, String password, Role roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Person() {
        super();
    }
}
