package com.revature;

import com.revature.model.User;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassInspector {

    public static void main(String[] args) {
        inspectClass(User.class);
    }

    public static void inspectClass(Class<?> clss) {
        listPublicConstructors(clss);
        listNonPublicConstructors(clss);
        listPublicFields(clss);
        listNonPublicFields(clss);
        listPublicMethods(clss);
        listDeclaredMethods(clss);
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
            System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers())  + "\n");
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
            System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers())  + "\n");
        }
    }

    private static void listPublicMethods(Class<?> clazz) {
        System.out.println("Listing the public methods of the class: " + clazz.getName());
        Method[] methods = clazz.getMethods();

        if (methods.length == 0) {
            System.out.println("\tThere are no public methods in the class " + clazz.getName());
        }

        for (Method method : methods) {
            System.out.println("\tName: " + method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println("\tDeclaring class: " + method.getDeclaringClass().getName());
            System.out.println("\tDeclared annotations: " + Arrays.toString(method.getDeclaredAnnotations()));

            System.out.println("\tParameter count: " + parameterTypes.length);
            for (Parameter param : method.getParameters()) {
                System.out.println("\t\tParameter name: " + param.getName());
                System.out.println("\t\tParameter type: " + param.getType());
                System.out.println("\t\tParameter annotations: " + Arrays.toString(param.getAnnotations()));
            }
            System.out.println();
        }
    }

    private static void listDeclaredMethods(Class<?> clss) {
        System.out.println("Listing the declared methods of the class "+clss.getName());
        Method[] methods = clss.getMethods();

        if (methods.length == 0) {
            System.out.println("\tThere are no non-public methods in the class "+clss.getName());
        }

        for (Method method : methods) {

            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                continue;
            }

            System.out.println("\tName: " + method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println("\tModifiers bit value: " + Integer.toBinaryString(method.getModifiers()));
            System.out.println("\tDeclaring class: " + method.getDeclaringClass().getName());
            System.out.println("\tDeclared annotations: " + Arrays.toString(method.getDeclaredAnnotations()));

            System.out.println("\tParameter count: " + parameterTypes.length);
            Parameter[] params = method.getParameters();
            for (Parameter param : params) {
                System.out.println("\t\tParameter name: " + param.getName());
                System.out.println("\t\tParameter type: " + param.getType());
                System.out.println("\t\tParameter annotations: " + Arrays.toString(param.getAnnotations()));
            }
            System.out.println();
        }
    }
}
