package com.revature.generics;

import java.util.LinkedList;
import java.util.List;

public class NonGenericClass {

    Object instance;

    List objects;

    //array of objects
    Object[] objArray;

    public NonGenericClass(Object instance, List objects, Object[] objArray) {
        this.instance = instance;
        this.objects = objects;
        this.objArray = objArray;
    }

    public NonGenericClass(Object instance) {
        this.instance = instance;
    }


}
