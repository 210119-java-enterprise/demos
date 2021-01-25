package com.revature.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {
    //Scanner is used primarily for parsing input streams

    //System.in represents input stream from console
//    static Scanner consoleReader = new Scanner(System.in);
    public static void main(String[] args) {
        //Reading Input using Scanner class
/*


        System.out.print("Please enter your username");
        String username = consoleReader.next();

        System.out.println("Please enter your password");
        String password = consoleReader.next();
        System.out.printf("The credentials you've provided were: %s and %s\n", username, password);

        int age = getAge();
*/

        //Reading input from BufferedReader


        // Verbose Declaration
       /* InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader verboseReader = new BufferedReader(inputStreamReader);
*/
        //Concise Declaration
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        //the new InputStreamReader(System.in) is NOT eligible for garbage collection because it is an indirect reference
        try{
            System.out.println("Please enter your first name");
            String firstName = consoleReader.readLine();
            System.out.printf("Your name is %s", firstName);

        }
        catch(IOException e){
        e.printStackTrace();
        }

    }

    /*public static int getAge(){
        int age =0;
        try {
            System.out.println("Please enter your age");
            age = consoleReader.nextInt(); //can throw an InputMismatchException if given bad data
            System.out.printf("Your age is %d\n", age);
        }catch(Exception e){
            System.err.println("That's not a number");
        }
        return age;
    }*/
}
