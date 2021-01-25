package com.revature.nested;

//import com.revature.nested.OuterClass;
import com.revature.nested.Operable;
import com.revature.nested.Printable;
import com.revature.nested.SimpleAbstractClass;

import java.util.function.Predicate;

import static com.revature.nested.OuterClass.StaticInnerClass;
public class Driver {

    public static void main(String[] args) {

//        // We can declare the type by utilizing the "dot" operator for the type
//        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass("");
//
//        // Here we can see a little better. We need an instance of the outer class to instantiate
//        // the instance scoped inner class.
//        OuterClass outer = new OuterClass();
//        OuterClass.InnerClass inner = outer.new InnerClass("");

        // Without static importing, just import the outer class and you'll have access to instantiation
        // through this syntax.
        //OuterClass.StaticInnerClass innerStatic = new OuterClass.StaticInnerClass("");

//        StaticInnerClass innerStatic = new StaticInnerClass("");
//        innerStatic.setInnerState("this is the new inner state");
//        System.out.println(innerStatic.getInnerState());

//    // Class declarations can be made in whatever scope we need them to be.
//    // Method scope
//    class Try {
//        public int someNum;
//    }
//
//    Try hello = new Try();
//
//
//    if(true){
//        // Local scope
//        class newClass {
//            public int someNum;
//        }
//
//        newClass hello1 = new newClass();
//    }

//        class OperableImpl implements Operable {
//
//            @Override
//            public double operate(double a, double b) {
//                return a * b;
//            }
//        }
//
//        OperableImpl opl = new OperableImpl();
//        System.out.println(opl.operate(2.5,6.7));
//
//        // The way of Java v7
//        // Anonymous Class
//        SimpleAbstractClass abs = new SimpleAbstractClass() {
//
//            @Override
//            public int sum(int a, int b) {
//                return a + b;
//            }
//        };
//
//        System.out.println(abs.sum(4,2));
//
//        // It can also be done with interfaces.
//        Operable op = new Operable() {
//            @Override
//            public double operate(double a, double b) {
//                return a/b;
//            }
//        };
//
//        System.out.println(op.operate(4.3, 5.54));
//
//
//        // The way of Java v8
//        // Creating an anonymous inner class, but all it is asking of you is
//        // to provide syntax for the abstract method.
//        // Lambda expressions only work with functional interfaces (interfaces with 1 method)
//        Operable lambdaOp = (double a, double b) -> {
//            return a/b;
//        };
//
//        // Using the lambda expression
//        System.out.println(lambdaOp.operate(4.4, 5.5));
//
//        // No need to put the types, java already knows their types.
//        // If the body is a one line return, omit the curly braces and the return statement.
//        // What you put will be returned.
//        Operable op = (a,b) -> a*b;
//
//        // A built in java functional interface, Predicate will perform some kind of test and
//        // return a boolean result.
//        Predicate<Integer> pred = i -> i<10;
//        System.out.println(pred.test(5));
//        System.out.println(pred.test(16));

        // Literally all we want to do is print the provided string to the console.
        Printable print = s -> System.out.println(s);

        // Method reference
        Printable print2 = System.out::println;

        print.print("This was done with a lambda.");
        print2.print("This was done with a method reference.");



    }
}
