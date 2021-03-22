package day3demo.abstractions;

public class Cat extends Animal {
    
    // Variable shadowing (generally bad practice and isn't used)
    public int numLives;
    
    private String breed;
    private boolean furry;

    public Cat() {
        System.out.println("Cat no-arg constructor called.");
        this.numLives = 9;
        this.breed = "Maine Coon";
        this.furry = true;
        this.value = "cat value"; // visible since inherited from Animal (public)
        this.thing = "cat thing"; // visible since inherited from Animal (protected)
    }

    public Cat(int numLives, String breed, boolean hasFur) {
        System.out.println("Cat explicit constructor called.");
        this.numLives = numLives;
        this.breed = breed;
        this.furry = hasFur;
    }

    // Needs to implement makeSound() to extend Animal
    @Override // include annotations for readability
    public void makeSound() {
        System.out.println("The cat meows.");
    }

    // Can override eat(), but doesn't need to
    // @Override
    // public void eat() {
    //     System.out.println("The cat chews its preferred catfood.");
    // }

    public void climb() {
        System.out.println("The cat decides to climb a tree.");
    }

    // @Override    // Not an override, cannot override static members
    public static void foo() {
        System.out.println("catbar");
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isFurry() {
        return furry;
    }

    public void setFurry(boolean furry) {
        this.furry = furry;
    }

    @Override
    public String toString() {
        return "Cat [breed=" + breed + ", furry=" + furry + ", numLives=" + numLives + "]";
    }
}
