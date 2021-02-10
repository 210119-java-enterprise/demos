package com.revature.abstractions;

/*
    Abstract classes

        - Cannot be directly instantiated (cannot use the new keyword), must have a concrete implementation by means of
            one or more subclasses
                + all abstract methods in the class MUST be implemented by concrete subclasses

        - Still have constructors
 */
public class Cat extends Animal {

    // variable shadowing
    public int numberOfLives;

    private String breed;
    private boolean hasFur;

    public Cat() {
        System.out.println("Cat no args constructor"); //not technically the first line (its super)
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur = true;
        this.value = "cat value"; // this is visible because it is inherited from Animal
        this.thing = "cat thing"; // also inherited (protected access)
    }

    public Cat(int numberOfLives, String breed, boolean hasFur) {
        System.out.println("Cat parametrized constructor");
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
        System.out.println("Awww, how cute, the cat makes cookies.");
    }

    @Override
    public int getNumberOfLives() {
        Animal.doStuff(); // If you are going to access static members, best practice dictates that you prefix the
                            // field/method call with the name of the class that owns it.
        doStuff();
        return numberOfLives; //9
    }

    public int getAnimalField() {
        this.doStuff(); // technically legal, but not best practice. Instead use Cat.doStuff()
        return super.numberOfLives; //1
    }

//    @Override //static methods cannot be overridden, but only redeclared (shadowed)
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
