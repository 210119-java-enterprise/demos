package com.revature.models;

import java.io.Serializable;

//POJO design Pattern
/*
    -Design pattern that encapsulates the states and behaviors of a domain object
    -synonyms: models entities, beans
    -Characteristics
        +have private fields\attributes\states
        +has one or more constructors for instantiation the class
        +exposes getters\setters for each private field
        +overrides the Object classes .equals(), and .toString()

 */
public class Person implements Serializable {
    private int id;
    private String username;
    private String password;
    Private Role role;

    public Person() {
        super();
    }

    public Person(String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role=role;

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

    public Role getRole(){
        return role;

    }
    public Role setRole(Role role){
        this.role=role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (username != null ? !username.equals(person.username) : person.username != null) return false;
        if (password != null ? !password.equals(person.password) : person.password != null) return false;
        return Role != null ? Role.equals(person.Role) : person.Role == null;
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (Role != null ? Role.hashCode() : 0);
//        return result;
//    }

    @Override
    public int hashCode(){
        return Obects.hash(id,username,password,role);
    }

    public String toString(){
        return "Person{"+", username='"+username +'\'' +", password='"+password +'\''+",role="+role+'}';

    }

}
