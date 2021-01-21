package com.revature.abstractions;

public class Cat extends Animal {

    //shadowing because your overriding the declaration in the parent
    public int numberOfLives;
    private boolean hasFur;
    private String breed;
    public Cat() {
           this.numberOfLives = 9;
           this.breed = "shorthair";
           this.hasFur = true;
           this.value ="cat value";
           this.thing = "cat thing";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "numberOfLives=" + numberOfLives +
                ", hasFur=" + hasFur +
                ", breed='" + breed + '\'' +
                '}';
    }

    public Cat(int numberOfLives, String breed, boolean hasFur) {
        System.out.println("cat paramaterized called");
        this.numberOfLives = 9;
        this.breed = "short";
        this.hasFur = true;
    }

//    public int getAnimalField() {
//        this.doStuff();
//        return super.numberOfLives; // 1
//    }

    public static void doStuff () {
        System.out.println("some stuff done");
    }

    @Override // not required but flag for other developers
    public void makeSound() {
        System.out.println("meow");
    }

    //goes to cat
    public int getNumberOfLives() {
        return numberOfLives;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    //goes to animal
    public int getAnimalField() {
        return super.numberOfLives;
    }
}
