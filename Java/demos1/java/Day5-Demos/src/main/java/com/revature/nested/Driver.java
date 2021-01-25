package com.revature.nested;


// import static com.revature.nested.OuterClass.StaticInnerClass; -> allows us to take away the outerclass declarations

import com.revature.nested.Operable;
import com.revature.nested.OuterClass;
import com.revature.nested.Printable;
import com.revature.nested.SimpleAbstractClass;

import java.util.function.Predicate;

public class Driver {
    public static void main(String[] args) {
//        // We can declare the type by utilizing the dot operator for the type
//        OuterClass.InnerClass inner2 = new OuterClass().new InnerClass("inner2");
//
//        //We need an instance of the outerclass to instantiate the instance scoped inner class
//        OuterClass outer = new OuterClass();
//
//        //Syntax to instantiate inner class (weird)
//        OuterClass.InnerClass inner = outer.new InnerClass("inner");

//        OuterClass.StaticInnerClass innerStatic = new OuterClass.StaticInnerClass("staticInnerState");


//    // class declarations can be made in whatever scope we need them to be
//    class Try {
//        public int someNum;
//    }
//
//    Try trial = new Try();
//
//    boolean maybe = true;
//
//    if(maybe) {
//        class TryLocal{};
//        TryLocal localTry = new TryLocal();
//    }

//        class NestedConcrete extends SimpleAbstractClass {
//
//            public int sum (int a, int b) {
//                return a + b;
//            }
//        }
//
//        // basically abs becomes an 'anonymous class' or basically a blank object that can do what is defined in the
//        //  abstract class
//        SimpleAbstractClass abs = new SimpleAbstractClass() {
//            @Override
//            public int sum(int a, int b) {
//                return super.sum(a, b);
//            }
//        };
//
//        // can also be done with interfaces
//        Operable op = new Operable() {
//            @Override
//            public int operate(int a, int b) {
//                return 0;
//            }
//        };
//
//
//        // java 8 way (LAMBDAS)
//        // Create an anonymous inner class, give the abstrac method the implementation that you provided
//        //  with the labnmda exspression and instanciate it.
//        Operable lambdaOp = (double a, double b) -> {
//            return a/b;
//        };

//        //no need to put curly braces and all that jazz if your just doing a single operation on the items
//        //if the body is a one line return, omit the curly braces and the return statement.
//        Operable op = (a, b) -> a+b;
//
//        //generics
//        //a built in java functional interface, predicate will perform some kind of test and return boolean
//        Predicate<Integer> pred = (i) -> i<10;
//
//        System.out.println(pred.test(5));
//        System.out.println(pred.test(16));

        //literally all we want to do is print provided string to the console
        Printable print = (s) -> System.out.println(s);

        //method reference
        Printable print2 = System.out::println;
        Operable op2 = OuterClass.op::operate;
        //following two declarations are funcitonally the same thing
        Operable op3 = Math::min;
        Operable example = (double a, double b) -> {
            return Math.min(a,b);
        };

        print.print("this was done with a lambda");
        print2.print("done with method reference");

    }
}
