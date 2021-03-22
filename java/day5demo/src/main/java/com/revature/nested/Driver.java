package com.revature.nested;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// can use static import to only import specific static members of a class (can't create instances)
// import static com.revature.nested.OuterClass.StaticClass;

public class Driver {
    public static void main(String [] args) {
        OuterClass outer = new OuterClass();
        // // Can declare type by using dot operator
        OuterClass.InnerClass inner = outer.new InnerClass();

        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();

        // don't need an instance, just the class since it's a static inner class
        OuterClass.StaticClass sInner = new OuterClass.StaticClass("Static class");

        // Can static import and refer to static class without outer class
        // StaticClass sInner = new StaticClass("Static class");


        // Works, but is method scope (dies when main() dies)
        class TryMethod {
            public int someInt;
        }
        TryMethod var = new TryMethod();


        Boolean maybe = true;
        if(maybe) {
            // You can, but why?
            class TryLocal {}
            TryLocal localTry = new TryLocal();
        }


        // Can find a use for this, but a bit too much typing and a bit unnecesary
        class NestedConcrete extends SimpleAbstractClass {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        }
        NestedConcrete nc = new NestedConcrete();
        System.out.println(nc.sum(1,2));

        // Again, can do but not too much memory usage and unnecessary
        // More useful than above, as unique implementations of interfaces can be nice
        class OperableImplementation implements Operable {
            @Override
            public double operate(double a, double b) {
                return a * b;
            }
        }
        OperableImplementation oi = new OperableImplementation();
        System.out.println("" + oi.operate(3.14, 2.7));

        // -----------------------------------------
        // Java 7 way

        // Instead of creating an entire class and instantiating it, can use anonymous classes
        // sac holds instance of anonymous class with unique implementation of the abstract class
        // Can only implement or extend 1 class
        SimpleAbstractClass sac = new SimpleAbstractClass(){
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        System.out.println(sac.sum(1,3));

        // Can do the same for interfaces
        Operable op = new Operable(){
            @Override
            public double operate(double a, double b) {
                return a*b;
            }
        };
        System.out.println(op.operate(1.5, 5.1));


        // ----------------------------------------------------
        // Java 8 way
        System.out.println("+--------------------------------+");
        
        // Create anonymous inner class, give abstract method the implementation that
        //      you provided with lambda expression, and instantiate it
        // Limited to classes with 1 method (functional classes/interfaces)
        Operable lambdaOp = (double a, double b) -> {
            return a*b;
        };
        System.out.println("operate(2.7, 5.3) with a*b lambda implementation:\n\t\t" + lambdaOp.operate(2.7, 5.3));
        // Same as lambdaOp
        Operable op1 = (a,b) -> a*b;

        // built-in java functional interface. Preforms test and returns boolean
        Predicate<Integer> pred = i -> i<10;
        System.out.println("Is 5 < 10?\t" + pred.test(5));
        System.out.println("Is 14 < 10?\t" + pred.test(14));

        // print provided string to console with a lambda
        Printable print = (s) -> System.out.println(s);

        // method reference, same as above implementation
        Printable print2 = System.out::println;

        print.print("Hello there \t(testing lambda)");
        print2.print("General Kenobi\t(testing method reference)");

        // Does the same thing
        Operable op2 = Math::min;
        Operable op3 = (double a, double b) -> {
            return Math.min(a,b);
        };
        System.out.println("Is 2 or 4 less:\t" + op2.operate(2, 4));

        

        /**
         *      Legal lambda syntaxes
         *          - (parameter) -> expression
         *          - parameter -> expression
         *          - parameter -> {code block of expressions}
         *          - (parameter, parameter) -> expression
         *          - (parameter, parameter) -> {code block of expressions}
         *          - () -> expression
         *          - () -> {code block of expressions}
         */

         // How can we print these out?
         List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
         
         System.out.println("-----------------------");
         // for i loop
         for (int i = 0; i < strings.size(); i++) {
             System.out.println(strings.get(i));
         }

         System.out.println("-----------------------");
         // for each loop
         for (String string : strings) {
             System.out.println(string);
         }

         System.out.println("-----------------------");
         // Using lambda
         strings.forEach(str -> System.out.println(str));

         System.out.println("-----------------------");
         // Using method reference
         strings.forEach(System.out::println);

         


    }
}
