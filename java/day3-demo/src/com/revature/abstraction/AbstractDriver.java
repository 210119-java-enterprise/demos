package com.revature.abstraction;
import java.lang.*;

public class AbstractDriver {

    public static void main(String args[]){

        //cannot directly instantiate abstract classes!
        // Animal noAnimal = new Animal();

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8,"Sphinx", false);
        Cat hisCat = new Cat(3, "Persian", true);
        Cat herCat = new Cat(5," Serval", true);


        System.out.println("------------------");

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.hasFur());
        System.out.println(hisCat.hasFur());

        System.out.println("------------------");

        /*
            Covariance is when you have a reference of a super type that points to an object of
            a subtype. This reference will have access to only the states and behaviors of the
            declared reference type. Although, if any methods of the parent are overridden by
            the subtype, those methods will behave as they do for the subtype.
         */
        Animal someAnimal = new Cat();
        System.out.println(someAnimal.numberOfLives); // 1 (Animal.numberOfLives)
        System.out.println(((Cat) someAnimal).getNumberOfLives()); // 9 (Cat.getNumberOfLives)

        someAnimal.eat();

        Cat someCat = (Cat) someAnimal;
        System.out.println(someCat);
        ((Cat) someAnimal).setBreed("Tabby");
        System.out.println(someCat); // someCat was changed! this is because it references the same object as someAnimal

    }

}


