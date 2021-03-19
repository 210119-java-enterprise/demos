package day3demo.abstractions;

/*
    Abstract classes
        - can't be directly instantiated
        - must have a concrete implementation by means of 1+ subclasses
        - all abstract methods in class must be be implemented by concrete subclass

        - still have constructors (subclass constructors call super())
        - can have 0+ abstract methods (methods w/0 any implementation)
*/
public abstract class Animal {

    public int numLives = 1;
    public String value;
    protected String thing;

    public Animal() {
        System.out.println("Animal constructor called.");
    }

    // concrete method w/ implementation
    public void eat() {
        System.out.println("The animal eats.");
    }

    // abstract method
    public abstract void makeSound();

    // Access static methods using classname.method() even in same class (e.g. Animal.foo())
    public static void foo() {
        System.out.println("bar");
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }
    
}
