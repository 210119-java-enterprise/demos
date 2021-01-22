package com.revature.abstractions;

public class abstractDriver{
    public static void main(String[] args){
        //cannot directly instantiate abstract classes!

        Cat myCat=new Cat();

        Animal someAnimal=new Cat();//covariance
        /*
        covariance is when you hace a reference
            of a super type that points to an object
            of a subtype. This regerence wil have access to only
            the states and behaviors
            of the declared reference type . although , if
            any methods of the parent are overridden by
            the subtype, those methods will behave as they do for the
            subtype

         */


    }


}