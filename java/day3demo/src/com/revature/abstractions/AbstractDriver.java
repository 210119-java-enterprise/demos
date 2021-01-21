package com.revature.abstractions;

public class AbstractDriver {

    public static void main(String[] args){
        //Cannot directly instantiate abstract classes
//        Animals noAnimal = new Animals();
//        Cat cat = new Cat();
//        cat.eat();
//        cat.makeSound();
//        cat.doStuff();//not good practice
//        Cat.doStuff();
//        Animals.doStuff();

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(3, "Servile", true);

        System.out.println("+--------------------+");

        Animals someAnimal = new Cat();
        System.out.println(someAnimal.numberOfLives);// 1
        System.out.println(someAnimal.getNumberOfLives());//9

    }
}
