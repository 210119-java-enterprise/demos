package com.revature.nested;

/**
 *  I'll leave this here. This was an example of documentation and implementations of
 *  interfaces and methods.
 */
public class SomeClass implements Runnable{


    @Override
    public void run() {

        class OperableImpl implements Operable {

            @Override
            public double operate(double a, double b) {
                return a * b;
            }
        }

        Operable oper = new OperableImpl();
        System.out.println(oper.operate(5.5, 7.7));

    }
}
