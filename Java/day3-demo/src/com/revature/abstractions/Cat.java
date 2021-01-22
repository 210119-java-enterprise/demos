package com.revature.abstractions;

public class Cat extends Animal{

    //variable shadowing
    public int numberOfLives = 9;

    private String breed;
    private boolean hasFur;

    public Cat() {
        this.numberOfLives = 9;
        this.breed = "d s h";
        this.hasFur = true;
    }
    public Cat(int numberOfLives, String brred, boolean hasFur) {

    }

    @Override // not required
    public void makeSound() {
        System.out.println("Meow");
    }

    // cannot include override since this method is not in animal
    public void makeCookies(){

    }

    public int getNumberOfLives() {
        return numberOfLives;
    }
}
