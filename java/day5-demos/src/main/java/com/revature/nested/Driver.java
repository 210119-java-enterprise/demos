package com.revature.nested;

//import com.revature.nested.OuterClass;
import com.revature.nested.Operable;
import com.revature.nested.OuterClass;
import com.revature.nested.Printable;
import com.revature.nested.SimpleAbstractClass;

import java.util.function.Predicate;

import static com.revature.nested.OuterClass.StaticInnerClass;

public class Driver {

    public static void main(String[] args) {
//        // We can declare the type by utilizing the 'dot' operator for the type
//        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass("");
//
//
//        // Here we can see a little better. We need an instance of the outer class to instantiate the
//        //      instance scoped inner class.
//        OuterClass outer = new OuterClass();
//
//        OuterClass.InnerClass inner = outer.new InnerClass("");
            //without static import. just import the outer class and you will have access to instantiation through
            //  this syntax
//        OuterClass.StaticInnerClass innerStatic = new OuterClass.StaticInnerClass("");
//
//        // with a static import, We can refer to the class like any other.
//        StaticInnerClass innerStatic = new StaticInnerClass("this is the new inner state");
//        System.out.println(innerStatic.getInnerState());

//
//        //class declarations can be made in whatever scope we need them to be.
//        class Try {
//            public int someNum;
//        }
//
//        Try trial = new Try();
//
//        boolean maybe = true;
//
//        if(maybe){
//            class TryLocal{}
//            TryLocal localtry = new TryLocal();
//        }

        // We can find a use for this, but still a little too much typing and a little unnecessary
//    class NestedConcrete extends SimpleAbstractClass {
//
//        @Override
//        public int sum(int a, int b) {
//            return a + b;
//        }
//    }
//
//    NestedConcrete nested = new NestedConcrete();
//        System.out.println(nested.sum(34,34));
//
//        //we can utilize unique implementations in circumstances where we need something once
//    class OperableImpl implements Operable {
//
//        @Override
//        public double operate(double a, double b) {
//            return a * b;
//        }
//    }
//
//    Operable oper = new OperableImpl();
//        System.out.println(oper.operate(5.5, 7.7));
//
//        //The way of java 7
//        //anonymous class
//        SimpleAbstractClass abs = new SimpleAbstractClass() {
//            @Override
//            public int sum(int a, int b) {
//                return a + b;
//            }
//        };
//
//        System.out.println(abs.sum(4,3));
//
//        //It can also be done with an interface
//        Operable op = new Operable() {
//            @Override
//            public double operate(double a, double b) {
//                return a/b;
//            }
//        };
//
//        System.out.println(op.operate(4.43,54.34));
//
//        //the java 8 way
//        //Create an anonymous inner class, give the abstract method the implementation that you
//        //  provided with the lamdba expression, and instantiate it.
//        Operable lambdaOp = (double a, double b) -> {
//            return a/b;
//        };
//        //normal usage
//        System.out.println(lambdaOp.operate(43.43,3556.356));
//
//        //No need to put the type the parameters, java already knows their types.
//        //If the body is a one line return, omit the curly braces and the return statement. What you put, will be returned.
//        Operable op = (a, b) -> a+b;
//
//        //a built in java functional interface, Predicate will perform some kind of test and return a boolean result
//        Predicate<Integer> pred = i -> i<10;
//
//        System.out.println(pred.test(5));
//        System.out.println(pred.test(16));
//
        //literally all we want to do is print the provided string to the console
        Printable print = (s) -> System.out.println(s);

        //method reference
        Printable print2 = System.out::println;

        //the following lines are equivalent
        Operable op2 = Math::min;
        //what else that would look like
        Operable example = (double a, double b) -> {
            return Math.min(a,b);
        };


        print.print("this was done with a lambda");
        print2.print("this was done with a method reference");



    }
}
