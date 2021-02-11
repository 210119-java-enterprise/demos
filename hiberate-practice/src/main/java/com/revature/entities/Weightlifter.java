package com.revature.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "weightlifters")
public class Weightlifter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "weightlifter_id", unique= true)
    private int weightlifter_id;

    @Column(name = "firstname", nullable=false)
    private String firstname;

    @Column(name = "lastname", nullable= false)
    private String lastname;

    @Column(name = "weight", nullable= false)
    private double weight;

    @Column(name = "height", nullable= false)
    private double height;

    @Column(name = "country", nullable= false)
    private String country;

    public int getWeightlifter_id() {
        return weightlifter_id;
    }

    public void setWeightlifter_id(int weightlifter_id) {
        this.weightlifter_id = weightlifter_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
