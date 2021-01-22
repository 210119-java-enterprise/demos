package com.revature;
import Role.java;

public class Person {
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
        Person(username, password, role);
        this.id = id;
    }


    /*
        Getters and Setters
        -------------------------------------------
    */
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


}