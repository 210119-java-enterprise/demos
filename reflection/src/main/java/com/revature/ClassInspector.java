package com.revature;

import com.revature.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInspector {

    public static void main(String[] args) {
        inspectClass(User.class);
    }

    public static void inspectClass(Class<?> clazz) {
        listPublicConstructors(clazz);
        listNonPublicConstructors(clazz);
    }

    public static void listPublicConstructors(Class<?> clazz) {
        System.out.println("Printing the public constructors of the " + clazz.getName());
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("\tConstructor name: " + constructor.getName());
            System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n");
        }
    }

    public static void listNonPublicConstructors(Class<?> clazz) {
        System.out.println("Printing the non-public constructors of the " + clazz.getName());
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if ((constructor.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                continue;
            }
            System.out.println("\tConstructor name: " + constructor.getName());
            System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n");
        }

    }

}
