package com.revature.abstractions;

public class Cat extends Animal{

    //shadowing
    public int numberofLives=1;
    private String breed;
    private boolean hasfur;

    public Cat(int numberofLives) {
        System.out.println("peramertirized constructor");
        this.numberofLives = numberofLives;
    }

    public Cat(){
        System.out.println("noargs constructor");
        this.numberofLives=9;
        this.breed="shorthair";
        this.hasfur=true;
        this.value="cat value";
        this.thing="cat thing";

    }



    @Override //<--annotation
    public void makesound() {

    }
    //cannot include @override here without an error, since this method is not declared in Animal
    public void makecookies(){
        System.out.println("awwww cute, cat makes cookies");
    }




   /* @Override
    public static void doStuff(){
        System.out.println("this cat is doing stuff");
        }
*/

    public int getNumberofLives() {
        return numberofLives;
    }

    public void setNumberofLives(int numberofLives) {
        this.numberofLives = numberofLives;
    }
}
