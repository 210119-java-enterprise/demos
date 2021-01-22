package com.revature.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {

//    static Scanner consoleReader = new Scanner(System.in);
    public static void main(String[] args) {
        // reading input from the console using scanner class
        //System.in represents the input stream from the console
        //Scanner is particullry useful for parsing input strings



//        System.out.print("PLZ enter username: ");
//        String userName = consoleReader.next();
//
//        System.out.print("pls eneter password: ");
//        String password = consoleReader.next();
//
//        System.out.printf("The credentials you proved were %s and %s\n" ,userName, password);
//
//        int age = getAge();
//        System.out.println("your age is ");

    //-------------------------------------------------//
        //reading input from the console using BufferedReader

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("please enter your first name");
            String firstName = consoleReader.readLine();
            System.out.printf("your name is %s", firstName);

            System.out.println("provide your age: ");
            String stringAge = consoleReader.readLine();
            int age = Integer.parseInt(stringAge);
            System.out.printf("you will be 40 in %d years", (40 - age));

        } catch (IOException | NumberFormatException e) {
            System.err.println("oh no");
            e.printStackTrace();// used for debugging, usually logged to external file
        }


    }

//    public static int getAge() {
//
//        int age = 0;
//
//        try {
//            System.out.print("pls enter your age: ");
//            age = consoleReader.nextInt(); // can through InputMismatchException if given bad data
//            System.out.printf("Your age is: %d", age);
//        } catch (InputMismatchException ime){
//            System.err.println("\n caught ime");
//            ime.printStackTrace();
//        }catch (Exception e) {
//            System.err.println("\nThat's not a number dummy.");
//            //age = getAge();//recursive call results in stackoverflowError
//        }
//        return 0;
//    }

}
