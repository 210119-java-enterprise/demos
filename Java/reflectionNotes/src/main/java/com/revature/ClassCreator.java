package com.revature;

import com.revature.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ClassCreator {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        User u = null;
        Constructor<?> noArgConstructor = null;
        Constructor<?>[] constructors = User.class.getConstructors();

        u = (User) Arrays.stream(constructors)
                .filter(c -> c.getParameterTypes().length == 0)
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .newInstance();

        u.setId(10);
        u.setUsername("wsingleton");
        u.setPassword("password");
        System.out.println(u);
    }
}
