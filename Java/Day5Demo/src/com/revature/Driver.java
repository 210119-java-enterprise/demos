package com.revature;
//import com.revature.nested.OuterClass;

import com.revature.nested.Operable;
import com.revature.nested.OuterClass;
import com.revature.nested.Printable;
import com.revature.nested.simpleAbstractClass;

import java.security.Principal;
import java.util.function.Predicate;

public class Driver {

    public static void main(String[] args) {
//        // we can declare the type by utilizing the "dot" operator for the type
//    //    OuterClass.InnerClass inner2 = new OuterClass().new InnerClass("");
//      OuterClass outer = new OuterClass();
//

        // here we can see a little better.  we need an instance of the outer class to instantiate the
        // instance scope inner class.

//      OuterClass.InnerClass inner = outer.new InnerClass("");


    //    OuterClass.StaticInnerClass innerStatic = new OuterClass.StaticInnerClass("");

        // with a static import, we can refer to the class like any
//        StaticInnerClass innerStatic = new StaticInnerClass("this is the new inner state");
//        System.out.println(innerStatic.getInnerState());

        // class declaration can be made in whatever scope we need these to be.
//        class Try{
//            public int someNum;
//
//        }
//        Try trial = new Try();
//
//        boolean maybe = true;
//
//        if(maybe){
//            class TryLocal{}
//                TryLocal localtry = new TryLocal();
//
//        }

//        class nestedConcrete extends simpleAbstractClass {
//
//            @Override
//            public int Sum(int a, int b){
//                return a + b;
//            }
//
//        }
//
//        nestedConcrete nested = new nestedConcrete();
//        System.out.println(nested.Sum(34,34));
//
//

//        class OperableImpl implements Operable{
//
//            @Override
//            public double operate(double a, double b){
//                return a*b;
//            }
//        }
//
//        Operable oper = new OperableImpl();
//        System.out.println(oper.operate(5.5,7.7));

        // anonymous class
//        simpleAbstractClass abs = new simpleAbstractClass() {
//            @Override
//            public int Sum(int a, int b) {
//                return a+b;
//            }
//        };
//
//        System.out.println(abs.Sum(4,3));
//
//        // it can also be done with an interface
//        Operable op = new Operable() {
//            @Override
//            public double operate(double a, double b) {
//                return a/b;
//            }
//        };
//
//        System.out.println(op.operate(4.43,54.34));


        // they java 8 way
        // create an anonymous inner class, give the abstract method the implementation that you
        // provided with the lambda expression, and instantiate it.
//        Operable lambdaOp = (double a, double b) -> {
//            return a/b;
//        };
//
//        //normal usage
//        System.out.println(lambdaOp.operate(43.43,3556.356));

        // no need to put eh type the parameters, java already knows their types
        // if the body is a one line return, omit the curly braces and the return statement, what you put, will be returned
//        Operable op = (a,b) -> a+b;
//
//        // a built in java functional interface, predicate will perform some kind of test and return a boolean result
//        Predicate<Integer> pred =  i -> i<10;
//
//        System.out.println(pred.test(5));
//        System.out.println(pred.test(16));

        // literally all we want to do it print the provided string to the console
        Printable print = (s) -> System.out.println(s);

        // method reference
        Printable print2 = System.out::println;

        // the following lines are equivalent
        Operable op2 = Math::min;

        // what else that would look like
        Operable example = (double a, double b) -> {
            return Math.min(a,b);
        };

        print.print("this was done with a lampda");
        print2.print("this was done using  a method reference");



    }
}
