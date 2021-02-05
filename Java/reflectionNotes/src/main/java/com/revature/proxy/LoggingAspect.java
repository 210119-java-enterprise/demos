package com.revature.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingAspect implements InvocationHandler {
    
    private If original;

    public LoggingAspect(If original) {
        this.original = original;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
        System.out.printf("Method %s invoked at %s\n", method.getName(), LocalDateTime.now().toString());
        Object returnedObject = method.invoke(original, params);
        System.out.printf("Method %s returned at %s with value %s\n", method.getName(), LocalDateTime.now().toString(), returnedObject);
        return null;
    }
}
