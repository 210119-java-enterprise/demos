package com.revature;

import com.revature.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassCreator {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        User u = null;
        Constructor<?> noArgConstructor = null;
        Constructor<?>[] constructors = User.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == 0) {
                noArgConstructor = constructor;
                System.out.println(noArgConstructor.getName() + " "+ noArgConstructor.getParameterTypes().length);
                u = (User) noArgConstructor.newInstance();
                System.out.println(u);
                u.setId(10);
                u.setPassword("password");
                System.out.println(u);
            }
        }
    }
}
