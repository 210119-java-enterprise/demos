package com.revature.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {
    //static Scanner consoleReader = new Scanner(System.in);
    public static void main(String[] args) {
        //Reading input from the console using scanner

        //scanner is particularly useful for simple parsing of input streams
        //system.in is an input stream basically 'incoming data from the console'
//        Scanner consoleReader = new Scanner(System.in);
//        System.out.println("Please enter username: ");
//        String username = consoleReader.next();
//
//        System.out.println("Please enter password: ");
//        String password = consoleReader.next();
//        int age = getAge();
//
//        System.out.printf("Credentials you provided were: %s and %s\n", username, password);
//        System.out.printf("Your age is: %d", age);
//


        //---------------------------------

        //reading input from console using buffered reader
            // scanner can parse data but reader brings it all in as string

        //verbose declaration
        //InputStreamReader streamReader = new InputStreamReader(System.in);
        //BufferedReader verboseReader = new BufferedReader(streamReader);

        //consice declaration
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String username = "";
        String password = "";
        int age = 0;
        try {
            System.out.println("Please enter first name");
            String firstName  = consoleReader.readLine();
            System.out.println(firstName);
            System.out.println("Please enter age");
            String stringAge  = consoleReader.readLine();
            age = Integer.parseInt(stringAge);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int getAge() {
        int age = 0;
        try {
            System.out.println("Please enter age: ");
            //age = consoleReader.nextInt(); //can throw InputMismatchException if given bad data
        } catch (InputMismatchException e) {
            System.err.println("Only enter ages in integers");
            //age = getAge(); //CAN CALL A NEW REFERENCE TO GET IT AGAIN BUTTTT not with recursion
            age = 0;
            e.printStackTrace();
        }
        return age;
    }
}
