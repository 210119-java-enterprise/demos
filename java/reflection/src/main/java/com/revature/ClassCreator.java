package com.revature;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.revature.model.User;

public class ClassCreator {

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<?> noArgConstructor = null;
        User u = null;
        Constructor<?>[] constructors = User.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName() + " " + constructor.getParameterCount());
            if (constructor.getParameterCount() == 0) {
                noArgConstructor = constructor;
                u = (User) noArgConstructor.newInstance();
                System.out.println(u.toString());
                u.setId(10);
                u.setUsername("ngamble");
                u.setPassword("password");
                System.out.println(u.toString());
            } else {
                u = (User) constructor.newInstance(1, "lburroughs", "pass123");
                System.out.println(u.toString());
            }
        }

    }
}
