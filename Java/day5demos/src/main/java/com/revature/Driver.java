package com.revature;

//import com.revature.nested.InnerClass.OuterClass;
import com.revature.nested.Operable;
import com.revature.nested.OuterClass;
import com.revature.nested.Printable;
import com.revature.nested.SimpleAbstractClass;

import java.util.function.Predicate;

import static com.revature.nested.OuterClass.StaticInnerClass;

public class Driver {

    public static void main(String[] args) {
        // We can declare the type by utilizing the 'dot' operator for the type
        // Instantiates the outer class so that we can make an inner class in the same instance

//        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass("");
//
//        OuterClass outer = new OuterClass();
//
//        OuterClass.InnerClass inner = outer.new InnerClass("");
//
//
//        OuterClass.StaticInnerClass innerStatic = new OuterClass.StaticInnerClass("");

        // with a static import, we can refer to the class like any other
//        StaticInnerClass inner = new StaticInnerClass("this is the new state inner");
//        System.out.println(inner.getInnerState());

        //class declarations can be made in whatever scope we need them to be.
//        class Try {
//            public int someNum;
//        }
//
//        Try trial = new Try();
//
//        boolean maybe = true;
//
//        if (maybe) {
//            class TryLocal{};
//            TryLocal localtry = new TryLocal();
//        }

        // We can find a use for this, but still a little too much typing and a little unnecessary
//        class NestedConcrete extends SimpleAbstractClass {
//
//            @Override
//            public int sum(int a, int b) {
//                return a+b;
//            }
//        }
//
//        NestedConcrete nested = new NestedConcrete();
//        System.out.println(nested.sum(34, 34));

        // We can utilize unique implementation in circumstances where we need something once
//        class OperableImpl implements Operable {
//
//            @Override
//            public double operate(double a, double b) {
//                return a*b;
//            }
//        }
//
//        Operable oper = new OperableImpl();
//        System.out.println(oper.operate(5.5, 7.7));

        //The way of java 7
        //anonymous class
//        SimpleAbstractClass abs = new SimpleAbstractClass() {
//            @Override
//            public int sum(int a, int b) {
//                return a+b;
//            }
//        };
//
//        System.out.println(abs.sum(4, 3));
//
//        //It can also be done with an interface
//        Operable op = new Operable() {
//            @Override
//            public double operate(double a, double b) {
//                return a/b;
//            }
//        };
//
//        System.out.println(op.operate(4.23, 54.34));

        //the java 8 way
        //Create an anonymous inner class, give the abstract method the implementation that you provided with
        //the lambda expression, and instantiate it.
//        Operable lambdaOp = (double a, double b) -> {
//            return a/b;
//        };
//
//        //normal usage
//        System.out.println(lambdaOp.operate(43.43, 3556.356));

        //no ndeed to put the type parameters, java already knows their types.
        //If the body is a one line return, omit the curly braces and the return statement. What you put, will be returned.
//        Operable op = (a, b) -> a+b;
//
//        //a built in java functional interface, Predicate will perform some kind of test and return a boolean result
//        //Predicate<Integer> pred = (Integer i) -> i<10;
//
//        // With only one parameter, parenthesis are optional
//        Predicate<Integer> pred = i -> i<10;
//
//        System.out.println(pred.test(5));
//        System.out.println(pred.test(16));

        //literally all we want to do is print the provided string to the console
        Printable print = (s) -> System.out.println(s);

        //method reference
        Printable print2 = System.out::println;

        Operable op2 = Math::min;
        // is the same as
        Operable example = (double a, double b) -> {
            return Math.min(a, b);
        };

        print.print("this was done with a lambda");
        print2.print("this was done with a method reference");
    }
}
