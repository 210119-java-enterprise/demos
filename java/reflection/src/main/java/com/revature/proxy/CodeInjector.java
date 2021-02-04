package com.revature.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class CodeInjector implements InvocationHandler {
    private If original;

    public CodeInjector(If original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
        System.out.println("Before logic");
        System.out.printf("Method %s invoked at %s time\n", method.getName(), LocalDateTime.now().toString());
        Object returnedObj = method.invoke(original, params);
        System.out.printf("Method returned %s\n", returnedObj);
        System.out.println("After logic");
        return null;
    }
}
