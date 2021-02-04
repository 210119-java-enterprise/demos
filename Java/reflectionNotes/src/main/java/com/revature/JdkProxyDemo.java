package com.revature;

import com.revature.proxy.If;
import com.revature.proxy.Original;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {

    static class Handler implements InvocationHandler {

        private If original;

        public Handler(If original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            System.out.println("BEFORE LOGIC!");
            method.invoke(original, params);
            System.out.println("AFTER LOGIC!");
        }
    }

    public static void main (String[] args) {
        Original original = new Original();
        Handler handler = new Handler(original);

        If f = (If) Proxy.newProxyInstance(If.class.getClassLoader(), new Class[] {If.class}, handler);
    }
}
