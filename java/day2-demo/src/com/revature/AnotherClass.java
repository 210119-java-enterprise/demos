package com.revature;

import com.revature.packageA.SomeClass;

public class AnotherClass extends SomeClass {

    public AnotherClass() {

    }

    public void someMethod() {

        // Visible here because AnotherClass is a subtype of SomeClass and c is declared as protected
        this.c = 'a';

        // Interestingly, field SomeClass.c is not visible here even though AnotherClass is a subtype
        // Probably because of the way that we are trying to access the field.
        SomeClass someClass = new SomeClass();
//        someClass.c = 'a';

        // Not visible because AnotherClass is not in the same package as SomeClass
//        this.f = 5.0f;
//        someClass.f = 5.0f;
    }
}
