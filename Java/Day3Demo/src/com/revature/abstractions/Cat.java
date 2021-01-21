package com.revature.abstractions;

public class Cat extends Animal{

    // variable shadowing
    public int numberOfLives;

    private String breed;
    private boolean hasFur;

    public Cat(){
        System.out.println(" no args Cat constructor called!");
        this.numberOfLives = 9;
        this.breed = "Domestic shorthair";
        this.hasFur = true;
        this.value = "cat value";  // this is visible because it is inhereited from Animal
        this.thing = "cat thing"; // als inherited (protected access)
    }

    public Cat(int numberOfLives, String breed, boolean hasFur){
        System.out.println("args Cat constructor called!");
        System.out.println("Cat parameterized constructor called!");
        this.numberOfLives = numberOfLives;
        this.breed = breed;
        this.hasFur = hasFur;
    }


    @Override  // <--- annotation
    public void makeSound() {
        System.out.println("Meow");
    }

    // cannot include @Override here without an error since this method is not declared in Animal
    public void makeCookies(){
        System.out.println("awww how cute, cate makes cookies");
    }

    public int getNumberOfLives() {
 //       Animal.doStuff();  // if you are going to access static memebers, best practice
                            // dictates that you prefix the field/method call with the name of the class that owns it

        return numberOfLives;  // 9
    }

    public int getAnimalField(){
        return super.numberOfLives;  // 1
    }

    // @Override // static methods cannot be overridden but only redeclard (shadowed)
    public static void doStuff(){
        System.out.println("the cat is doing some stuff!");
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

    public String getBreed() {
        return breed;
    }

    public boolean hasFur() {
        return hasFur;
    }
}
