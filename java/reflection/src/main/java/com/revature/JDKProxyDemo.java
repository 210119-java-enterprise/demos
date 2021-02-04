package com.revature;

import java.lang.reflect.Proxy;

import com.revature.proxy.*;

public class JDKProxyDemo {


    public static void main(String[] args) {
        Original orig = new Original();
        CodeInjector handler = new CodeInjector(orig);

        // class loader loads class
        // Array of interfaces implemented by class
        // handler handles invocation
        If f = (If) Proxy.newProxyInstance(Original.class.getClassLoader(), new Class[] {If.class}, handler);
        // Instead of If.originalMethod() being called, calls CodeInjector.invoke()
        f.originalMethod("General Kenobi");
    }
}
