package com.revature;

import com.revature.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInspector {

    public static void main(String[] args) {
        //User user = new User(1);
        inspectClass(User.class);
        listNonPublicConstructors(User.class);
    }

    public static void inspectClass(Class<?> clss) {
        listPublicConstructors(clss);
    }

    public static void listPublicConstructors(Class<?> clss) {
        System.out.println("Printing the public constructors of the " + clss.getName());
        Constructor<?>[] constructors = clss.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("\tName: "+ constructor.getName());
            System.out.println("\tConstructor param types: "+ Arrays.toString(constructor.getParameterTypes())+"\n");
        }
    }

    public static void listNonPublicConstructors(Class<?> clss) {
        System.out.println("Printing the non-visible constructors of the " + clss.getName());
        Constructor<?>[] constructors = clss.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if ((constructor.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                continue;
            }
            System.out.println("\tName: "+ constructor.getName());
            System.out.println("\tConstructor param types: "+ Arrays.toString(constructor.getParameterTypes())+"\n");
        }
    }
}
