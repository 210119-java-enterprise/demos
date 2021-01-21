package com.revature.abstractions;

public class AbstractDriver {
    public static void main(String[] args){
        Animal someAnimal = new Cat(); // covariance is when you have a reference to of a super type that points to a object of a subtype;

        Cat someCat = (Cat) someAnimal;
        System.out.println(someCat);
        ((Cat) someAnimal).setBreed("Tabby");
        System.out.println(someCat);
    }
}
