package com.revature.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {

//    static Scanner consoleReader = new Scanner(System.in);

    public static void main(String[] args) {
/*
        //Reading input from the console using Scanner class

        // System.in represents the input stream from the console
        // Scanner is particularly useful for parsing input streams
        Scanner consoleReader = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String username = consoleReader.next();

        System.out.print("please enter your password: ");
        String password = consoleReader.next();

        System.out.printf("The credentials you provided were %s and %s\n", username, password);

        int age = getAge();
        System.out.printf("Your age is: %d", age);*/

        //--------------------------

        // Reading input from the console using BufferedReader

        // Verbose declaration
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader verboseReader = new BufferedReader(inputStreamReader);

        // Concise declaration
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Please enter your first name: ");
            String firstName = consoleReader.readLine();
            System.out.printf("Your name is %s", firstName);

            System.out.print("Provide your age: ");
            String stringAge = consoleReader.readLine();
            int age = Integer.parseInt(stringAge);
            System.out.printf("You will be 40 in %d years", (40-age));
        } catch (IOException | NumberFormatException e) {
            System.err.println("Oh no! You didn't give me a number!");
            e.printStackTrace(); // used for debugging (Usually will be logged to an external file)
        }
    }

    /*public static int getAge() {
        int age; // uninitialized, has no default value

        int age = 0;

        try {
            System.out.print("Please enter your age: ");
            age = consoleReader.nextInt(); // can throw an InputMismatchException if given bad data
            System.out.printf("Your age is: %d", age);
        } catch (InputMismatchException ime) {
            System.err.println("Caught a mismatch exception");
            ime.printStackTrace();
        } catch (Exception e) {
            System.err.println("\nThat's not a number, dummy.");
            age = getAge(); // recursive call results in StackOverflowError
        }
        return age;
    }*/
}
