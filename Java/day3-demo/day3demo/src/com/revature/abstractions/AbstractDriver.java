package com.revature.abstractions;

public class AbstractDriver {

    public static void main(String[] args) {

        //Animal noAnimal = new Animal(); //Cannot directly instantiate abstract classes!

        Cat myCat = new Cat();
        Cat yourCat = new Cat (8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.hasFur());
        System.out.println(hisCat.hasFur());

        System.out.println("+-----------------");

        /*
            Covariance is when you have a reference of a super type that points to an object of a subtype. This
            reference will have access to only the states and behaviours of the declared reference type. Although, if
            any methods of the parents are overridden by the subtype, those methods will behave as they do for the
            subtype.
         */
        Animal someAnimal = new Cat();
        System.out.println(someAnimal.numberOfLives); // 1 (Animal.numberOfLives)
        System.out.println(someAnimal.getNumberOfLives()); // 9 (Cat.getNumberOfLives

        someAnimal.eat();

        Cat someCat = (Cat) someAnimal;
        System.out.println(someCat.getNumberOfLives());

        System.out.println(someCat);

        ((Cat) someAnimal).setBreed("Tabby");
        System.out.println(someCat);
    }
}
