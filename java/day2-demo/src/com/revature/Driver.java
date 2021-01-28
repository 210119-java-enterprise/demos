package com.revature;

import com.revature.packageA.SomeClass;

public class Driver {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        someClass.x = 6; // visible here b/c x is declared as public

        // field c of SomeClass is not visible here since it is declared as protected
//        someClass.c = 'a';
    }
}
