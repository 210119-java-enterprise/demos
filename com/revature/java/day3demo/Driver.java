package com.revature.java.day3demo;
import java.util.regex.*;

public class Driver {
    public static void main(String [] args) {
        // ArrayDemo myAD = new ArrayDemo();
        // myAD.learningArrays();

        // throw new AuthenticationException("no reason", new NullPointerException());

        Pattern pattern = Pattern.compile("<.+>.*</.+>.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("<h1>Nayeem loves counseling</h1><h2>hi</h2>");
        boolean matchFound = matcher.find();
        System.out.println(matchFound);
        System.out.println(matcher.toString());
        // System.out.println(matcher);
    }
}
