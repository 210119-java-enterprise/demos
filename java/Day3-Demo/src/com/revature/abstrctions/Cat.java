package com.revature.abstrctions;

public class Cat extends Animal {

    // variable shadowing
    public int numberOfLives;

    private String breed;
    private boolean hasFur;

    public Cat() {
        System.out.println("Cat no-args constructor called!"); // not technically the first line (hint: its super)
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur = true;
        this.value = "cat value"; // this is visible because it is inherited from Animal
        this.thing = "cat thing"; // also inherited (protected access)
    }

    public Cat(int numberOfLives, String breed, boolean hasFur) {
        System.out.println("Cat parameterized constructor called!");
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
    }

    @Override // <--- annotation
    public void makeSound() {
        System.out.println("Meow");
    }

    // cannot include @Override here without an error, since this method is not declared in Animal
    public void makeCookies() {
        System.out.println("Awww how cute, cat makes cookies.");
    }

    public int getNumberOfLives() {
        Animal.doStuff(); // if you are going to access static members, best practice dictates that you prefix the
        // field/method call with the name of the class that owns it.
        return numberOfLives;
    }

    public int getAnimalField() {
        this.doStuff(); // technically legal, but no best practice. instead use Cat.doStuff()
        return super.numberOfLives; // 1
    }

    //    @Override // static methods cannot be overridden, but only redeclared (shadowed)
    public static void doStuff() {
        System.out.println("The cat is doing some stuff!");
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

    public boolean hasFur() {
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