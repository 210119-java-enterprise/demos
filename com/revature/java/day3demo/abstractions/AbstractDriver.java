package com.revature.java.day3demo.abstractions;

public class AbstractDriver {


    public static void main(String[] args) {
        // Animal a1 = new Animal();    // Can't directly instantiate abstract classes

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        System.out.println("+-------------------+");

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isFurry());
        System.out.println(herCat.getNumLives());

        System.out.println("+-------------------+");

        /*
        Covariance 
            - object of super type that points to object of subtype
            - only has access to states and behaviors of declared reference type
            - if any methods are overriden

        */
        Animal someAnimal = new Cat();
        System.out.println(someAnimal.numLives); // 1 since Animal has 1 life
        System.out.println(someAnimal.getNumLives()); // 9 since Cat overrides Animal.getNumLives()
                                                        // (behaves like subtype)
        someAnimal.eat();

        Cat someCat = (Cat) someAnimal;
        System.out.println(someCat);
        ((Cat) someAnimal).setBreed("Tabby");
        System.out.println(someCat.getBreed()); // someCat was changed
                                                // because someCat and someAnimal reference same object

    }
    
}
