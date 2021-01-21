package com.revature.abstractions;

public class AbstractDriver {

    public static void main(String[] args) {

        // Cntrl + / will comment out code.

        // Cannot directly instantiate abstract classes.
        // Animal noAnimal = new Animal();
        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        System.out.println("====================================");

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.HasFur());
        System.out.println(hisCat.HasFur());

        /*
            Covariance is when you have a reference of a super type that points to an object
            of a subtype. This reference will have access to only the states and behaviors of the
            declared reference type. Although, if any methods of the parent are overriden by the subtype,
            those methods will behave as they do for the subtype.
         */

        Animal someAnimal = new Cat(); //covariance
        System.out.println(someAnimal.numberOfLives);
        System.out.println();

        Cat someCat = (Cat) someAnimal; // down casting


    }
}
