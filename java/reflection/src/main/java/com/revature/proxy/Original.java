package com.revature.proxy;

public class Original implements If {
    @Override
    public String originalMethod(String s) {
        System.out.println(s);
        return s + " Hello there!";
    }
}
