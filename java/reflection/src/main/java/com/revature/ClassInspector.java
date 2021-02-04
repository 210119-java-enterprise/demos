package com.revature;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInspector {
    public static void main(String[] args) {
        inspectClass(User.class);
    }

    public static void inspectClass(Class<?> clazz) {
        listPublicConstructors(clazz);
        listNonPublicConstructors(clazz);
        listPublicFields(clazz);
        listNonPublicFields(clazz);
    }

    public static void listPublicConstructors(Class<?> clazz) {
        System.out.println("Printing visible constructors of the " + clazz.getName());
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("\tConstructor name: " + constructor.getName());
            System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n");
            System.out.println();
        }
    }

    public static void listNonPublicConstructors(Class<?> clazz) {
        System.out.println("Printing non-visible constructors of the " + clazz.getName());
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if ((constructor.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                continue;
            }
            System.out.println("\tConstructor name: " + constructor.getName());
            System.out.println("\tConstructor param types: " + Arrays.toString(constructor.getParameterTypes()) + "\n");    
            System.out.println();
        }
    }

    public static void listPublicFields(Class<?> clazz) {
        System.out.println("Printing public fields of the " + clazz.getName());
        Field[] fields = clazz.getFields();
        if (fields.length == 0) {
            System.out.println("There are no public fields in " + clazz.getName());
        }
        for (Field field : fields) {
            System.out.println("\tField name: " + field.getName());
            System.out.println("\tField type: " + field.getType());
            System.out.println("\tIs field primitive?: " + field.getType().isPrimitive());
            System.out.println();
        }
    }

    public static void listNonPublicFields(Class<?> clazz) {
        System.out.println("Printing non-public fields of the " + clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            System.out.println("\nThere are no non-public fields in " + clazz.getName());
        }
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                continue;
            System.out.println("\tField name: " + field.getName());
            System.out.println("\tField type: " + field.getType());
            System.out.println("\tIs field primitive?: " + field.getType().isPrimitive());
            System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
            System.out.println();
        }
    }
}
