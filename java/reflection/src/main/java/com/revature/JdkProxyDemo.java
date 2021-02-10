package com.revature;

import com.revature.proxy.LoggingAspect;
import com.revature.proxy.If;
import com.revature.proxy.Original;
import java.lang.reflect.Proxy;

public class JdkProxyDemo {

    public static void main(String[] args) {

        Original original = new Original();
        LoggingAspect handler = new LoggingAspect(original);
        If f = (If) Proxy.newProxyInstance(Original.class.getClassLoader(), new Class[] { If.class }, handler);
        f.originalMethod("Actual method logic!");

    }

}
