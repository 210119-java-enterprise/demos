package com.revature;
import com.revature.packageA.SomeClass;
public class Driver {
    public static void main(String[] args) {
    SomeClass someclass=new SomeClass();
    someclass.x=6;  //visible here
//not visible
        //someclass.c='a'
    }
}
