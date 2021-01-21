package com.revature.abstractions;

public class Cat extends Animal {
    // variable shadowing
    public int numberOfLives;
    private String breed;
    private boolean hasFur;

    public Cat() {
        System.out.println("cat no-arg const called");
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur = true;
        this.value = "cat value";
        this.thing = "cat thing";
    }

    public Cat(int life, String val, boolean thi) {
        System.out.println("cat no-arg const called");
        this.numberOfLives = life;
        this.breed = val;
        this.hasFur = thi;

    }
 @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    // cannot inluce override here since this method in not declaired in Animal
    public void makeCookies() {
       System.out.println("Awww how cute, cat makes cookies");
    }

    public int getAnimalfield() {
        Animal.doStuff();
        return super.numberOfLives;
    }

    public int getNumberOfLives() {
        return this.numberOfLives;
    }
    // cannot be overrided since its static
    public static void doStuff() {
        System.out.println("The Animal is doing some stuff");
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isHasFur() {
        return hasFur;
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
