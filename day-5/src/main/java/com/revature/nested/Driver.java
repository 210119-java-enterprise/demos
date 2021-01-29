package com.revature.nested;
//import com.revature.nested.Outerclass;

import static com.revature.nested.Outerclass.StaticInnerclass;
public class Driver {

    public static void main(String[]args){

//        //we can declare the type by utilizing the 'dot' operator for the type outerclass.innerClass inner=new outerClass.innerClass(")
//        Outerclass.Innerclass.inner2=new Outerclass().new Innerclass(innerState"");
//
//        //Her we can
//        Outerclass outer=new Outerclass();
//
//        Outerclass.Innerclass inner=  outer.new Innerclass(innerState"");

          //  Outerclass.StaticInnerclass innerStatic= new Outerclass.StaticInnerclass;
//        Object innerState;
//        StaticInnerclass innerStatic=new StaticInnerclass(innerState"this is the new inner state");
//        System.out.println(innerStatic.getInnerState());
        
//
//        class NestedConcrete extends SimpleAbstractClass{
//            @Override
//            public int sum(int a, int b) {
//                return a+b;
//            }
//        }
//        NestedConcrete nested=new NestedConcrete();
//        System.out.println(nested.sum(34,43));
//
//        class OperableImpl implements SimpleInterface{
//
//            @Override
//            public int operate(double a, double b) {
//                return 0;
//            }
//        }
//        SimpleInterface oper=new OperableImpl();
//        System.out.println(oper.operate(34.4,342.3));
//        SimpleInterface lan=(double a,double b)->{
//            return a/b;
//        };
//        System.out.println((lan.operate(34.23,234.5)));

        Printable print=(s)-> System.out.println(s);
        print.print("this was done with a lambda");

        //method reference
        Printable print2= System.out::println;
        print2.print("this was done with a method reference");



  }
        
}

