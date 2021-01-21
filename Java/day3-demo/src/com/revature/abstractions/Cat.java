package com.revature.abstractions;

public class Cat extends Animal {

    // variable shadowing
    public int numberOfLives;

    private String breed;
    private boolean hasFur;

    public Cat() {
        System.out.println("Cat constructor  called."); //not technically first line. Called super() first.
        this.numberOfLives = 9;
        this.breed = "Domestic Shorthair";
        this.hasFur = true;
        this.value = "cat value"; // this is visible because it is inherited from Animal.
        this.thing = "cat thing"; // also inherited
    }

    public Cat(int numberOfLives, String breed, boolean hasFur) {
        System.out.println("Cat param constructor called!");
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
    }

    @Override // <--- annotation
    public void makeSound() {
        System.out.println("MEOOW!");
    }

    // cannot include @Override since this method is not declared in its super.
    public void makeCookies() {
        System.out.println("Cat makes cookies.");
    }

    public int getNumberOfLives() {
        Animal.doStuff(); // if you are going to access static members, best practice dictates
                            // that you prefix the field/method call with the name of the class that owns it
        return numberOfLives;
    }

    public int getAnimalField() {
        return super.numberOfLives;
    }
    //@Override // static methods cannot be overriden, but only redeclared (shadowed)
    public static void doStuff() {
        System.out.println("The cat is doing some stuff.");
    }

    public String getBreed() {
        return breed;
    }

    public boolean HasFur() {
        return hasFur;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    //Alt + Insert gives you Generator.
}
