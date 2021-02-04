package com.revature;

import com.revature.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInspector {

    public static void main(String[] args) {
        //User user = new User(1);
        inspectClass(User.class);
        listNonPublicConstructors(User.class);
        listPublicFields(User.class);
        listNonPublicFields(User.class);
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

    public static void listPublicFields(Class<?> clss) {
        System.out.println("Printing public fields of the "+ clss.getName());
        Field[] fields = clss.getFields();
        if (fields.length == 0) {
            System.out.println("\tThere are no public fields in the class "+clss.getName());
        }

        for (Field field : fields) {
            System.out.println("\tField name: "+field.getName());
            System.out.println("\tField type: "+field.getType());
            System.out.println("\tIs field primitive? :: " + field.getType().isPrimitive() + "\n");
        }
    }

    public static void listNonPublicFields(Class<?> clss) {
        System.out.println("Printing non-public fields of the "+ clss.getName());
        Field[] fields = clss.getDeclaredFields();
        if (fields.length == 0) {
            System.out.println("\tThere are no non-public fields in the class "+clss.getName());
        }

        for (Field field : fields) {
            System.out.println("\tField name: "+field.getName());
            System.out.println("\tField type: "+field.getType());
            System.out.println("\tIs field primitive? :: " + field.getType().isPrimitive() + "\n");
        }
    }

    private static void listDeclareMethods(Class<?> clss) {
        System.out.println("Listing the public methods of the class "+clss.getName());

        Method[] methods = clss.getMethods();
        if (methods.length == 0) {
            System.out.println("\tThere are no public methods in the class "+clss.getName());
        }

        for (Method method : methods) {
            System.out.println("\tMethod name: "+method.getName());
            //System.out.println("\tMethod type: ");
            //System.out.println("\tIs field primitive? :: " + method.is + "\n");
        }
    }
}
