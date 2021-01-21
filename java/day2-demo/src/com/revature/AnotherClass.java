package com.revature;

import com.revature.packageA.SomeClass;

public class AnotherClass extends SomeClass {
    public AnotherClass(){
         //visible here
    }
    public void someMethod(){
        //visible here
        this.c='a';

//Probably because of the way that we are trying to access the field.
        SomeClass someclass = new SomeClass();
       // someclass.c='a';

        //not visible here
       //this.f =5.0f;
       //someclass.f=5.0f;

    }
}
