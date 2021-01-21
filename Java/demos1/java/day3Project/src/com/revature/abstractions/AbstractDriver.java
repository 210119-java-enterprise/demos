package com.revature.abstractions;

public class AbstractDriver {
   public static void main(String[] args) {
       Cat myCat = new Cat();
       Cat yourCat = new Cat (8, "Sphinx", false);
       Cat hisCat = new Cat (5, "persian", true);
       Cat herCat = new Cat(3, "serval", true);

       System.out.println(myCat.getBreed());

       //COVARIANCE - the REFERENCE TYPE (ANIMAL) has its methods overriden but not its variables
       Animal someAnimal = new Cat();
       System.out.println(someAnimal.numberOfLives); // the animal is an ANIMAL not a cat because number of lives is a field
       System.out.println(someAnimal.getNumberOfLives()); // animal in question is the CAT because the get method is overriden in cat

       someAnimal.eat();

       Cat someCat = (Cat) someAnimal;
       System.out.println(someCat);
       ((Cat) someAnimal).setBreed("tabby");
       System.out.println(someCat); // somecat was changed! references same object as someanimal
   }

}
