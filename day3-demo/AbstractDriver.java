package com.revature.abstractions;

public class AbstractDriver {

    public static void main(String[] args) {

        //Cannot directly instantiate abstract classes
        // Animal noAnimal = new Animal();

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(7, "Persian", true);
        Cat herCat = new Cat(5, "Serval", true);
    System.out.println("-------------------");

    System.out.println(myCat.getBreed());
    System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());

        System.out.println("-------------------");

        Animal someAnimal = new Cat();
        System.out.println(someAnimal.numberOfLives);
        System.out.println(someAnimal.getNumberOfLives());

        someAnimal.eat();

        Cat someCat = (Cat) someAnimal;
        System.out.println(someCat.getNumberOfLives());
        ((Cat) someAnimal).setBreed("Tabby");
        System.out.println(someCat); // someCat was changed this is because it refrences the same object as someAnimal


    }
}
