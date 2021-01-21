package com.revature.abstractions;

public class Cat extends Animal{

    public int numberOfLives; //variable shadowing...try to avoid it
    private String breed;
    private boolean hasFur;
    public Cat(){
        this.numberOfLives = 9;

    }
    public Cat(int numberOfLives, String breed, boolean hasFur){

        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;

    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
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

    @Override
    public String toString() {
        return "Cat{" +
                "numberOfLives=" + numberOfLives +
                ", breed='" + breed + '\'' +
                ", hasFur=" + hasFur +
                '}';
    }
}
