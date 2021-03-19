package com.revature.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsoleDriver {

    // Scanner used for parsing
    // static Scanner consoleReader = new Scanner(System.in);
    public static void main(String[] args) {

        // System.out.println("Please enter your username:");
        // String username = consoleReader.next();

        // System.out.println("Please enter your password:");
        // String password = consoleReader.next();

        // System.out.println("Please enter your age:");
        // int age = consoleReader.nextInt();   // Bad if input may not be an int
        // int age = getAge();

        // +-----------------------------------------+
        // BufferedReader made for reading all (or mostly) strings

        // Verbose declaration
        // InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // BufferedReader verboseReader = new BufferedReader(inputStreamReader);

        // Concise declaration
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Please enter your first name:");
            String firstName = consoleReader.readLine();
            System.out.printf("Your name is %s.\n", firstName);

            System.out.println("Provide your age:");
            String stringAge = consoleReader.readLine();
            int age = Integer.parseInt(stringAge); // Can throw NumberFormatException
            System.out.printf("You will be 40 in %d years.\n", (40 - age));
        } catch (IOException | NumberFormatException e) {
            System.err.println("You didn't give me a number!");
            e.printStackTrace(); // Used for debugging (usually logged to external file)
        } 
    }

    public int getAge() {
        // TODO: put safe grabbing of age here

        return 0;
    }
}
