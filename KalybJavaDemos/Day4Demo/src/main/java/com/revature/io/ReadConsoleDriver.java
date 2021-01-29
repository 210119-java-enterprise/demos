package com.revature.io;

import java.util.Scanner;

public class ReadConsoleDriver {
    static Scanner consoleReader = new Scanner(System.in);

    public static void main(String[] args){
        // reading input from the console using the Scanner class

        // System.in represents the input stream from the console

        System.out.print("Please enter your username: ");
        String username = consoleReader.next();

        System.out.print("Please enter your username: ");
        String password = consoleReader.next();

        System.out.printf("The credentials you provided were: %s and %s\n", username, password);

        int age = getAge();
        System.out.printf("your age is: %d", age);


        //------------------------------

        // reading input from the console using BufferedReader

        // verbose declaration

        /*
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader verboseReader = new BufferedReader(inputStreamReader);

         // concise delcaration
         BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.print("Please enter your first name: ");
            String firstName = consoleReader.readLine();
            System.out.printf("Your name is %s", firstName);

            System.out.print("Provide your age: ");
            String stringAge = consoleReader.readLine();
            int age = Integer.parseInt(stringAge);
            System.out.printf("You will be 40 in %d years", (40 - age));
         } catch(IOException e){
            e.printStackTrace();
         }


         */

    }

    public static int getAge(){
        int age = 0; // uninitialized, has no default value (not even 0)

        try{
            System.out.println("please enter your age: ");
            age = consoleReader.nextInt();
        }catch(Exception e){
            System.out.println("\nThat's not a number, dummy.");
    //        age = getAge();
        }
        return age;
    }
}


