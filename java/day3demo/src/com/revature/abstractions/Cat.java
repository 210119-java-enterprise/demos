package com.revature.abstractions;

public class Cat extends Animals{

    //variable shadowing (usually not needed and avoided)
    public int numberOfLives;

    private String breed;
    private boolean hasFur;

    public Cat (){
        System.out.println("Cat no args constructor called");
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur = true;
        this.value = "cat value";//inherited
    }

    public Cat(int numberOfLives, String breed, boolean hasFur){
        System.out.println("Cat parameterized constructor called");
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
    }

    @Override //good practice to include this for ease of reading
    public void makeSound(){
        System.out.println("meow");
    }

    public void makesMuffins(){
        System.out.println("how cute");
    }

    //this is shadowing a method since static methods cannot be overridden, not really used
    public static void doStuff(){
        System.out.println("The cat does some stuff");
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }
}
