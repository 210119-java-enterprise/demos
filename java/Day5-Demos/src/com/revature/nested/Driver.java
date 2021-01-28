package com.revature.nested;

import com.revature.nested.OperableInterface;
import com.revature.nested.OuterClass;
import com.revature.nested.OuterClass.StaticInnerClass;
import com.revature.nested.Printable;
import com.revature.nested.SimpleAbstractClass;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.function.Predicate;

public class Driver {
    public static void main (String[] args){
 /*
        //we can declare the type by using the dot operator for the type
        OuterClass outer= new OuterClass();
        OuterClass.InnerClass inner= outer.new InnerClass("");

        //we need to instantiate th outer class and then instantiate the inner from that
        OuterClass.InnerClass inner2= new OuterClass().new InnerClass("");


*/
        //without static import we use this syntax
        //OuterClass.StaticInnerClass innerStatic=new OuterClass.StaticInnerClass("");

        //with static import
        //StaticInnerClass innerStatic = new StaticInnerClass("sa");
        //innerStatic.setInnerState("ssssssssssssssss");
        //System.out.println(innerStatic.getInnerState());



//        class Wow{
//            public int num=5;
//        }
//        Wow wow=new Wow();
//        System.out.println(wow.num+" wow ");



//
//        class NestedConcrete extends SimpleAbstractClass{
//            @Override
//            public int sum(int a, int b){
//                return a+b;
//            }
//
//        }




//        class Operable implements OperableInterface{
//            @Override
//            public double operate(double a, double b){
//                return a*b;
//            }
//        }
//        OperableInterface oper=new Operable();
//        System.out.println(oper.operate(2.3,54.2));


//        //The way of Java 7
//        //anonymous class
//        SimpleAbstractClass abs = new SimpleAbstractClass(){
//            @Override
//            public int sum(int a, int b){
//                return a+b;
//            }
//        };
//
//        OperableInterface op = new OperableInterface() {
//            @Override
//            public double operate(double a, double b) {
//                return a/b;
//            }
//        };



//        //The Java 8 way
//        //the lambda expression
//        //Creates an anonymous inner class
//        // limited to interfaces with only one method (Functional Interface --@FunctionalInterface)
//        OperableInterface lambdaOp= (double a, double b) -> {
//            return a/b;
//        };
//
//        //reduced even more
//        OperableInterface op=(a,b)->a+b;



        //Predicate<Integer> pred= i -> i<10;


        Printable print = (s)-> System.out.println(s);
        print.print("this was done via lambda");

        //method reference
        Printable print2=System.out::println;
        print2.print("this was done via a method reference");

        //method References
        //OuterClass.op::operate;

        //OperableInterface op2=OuterClass.op::operate;


        OperableInterface op3=Math::min;
                // op3 and op4 are the same thing
        OperableInterface op4=(double a,double b) ->{
            return Math.min(a,b);
        };

    }
}
