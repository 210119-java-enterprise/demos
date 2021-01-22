package com.revature.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {

//    static Scanner consoleReader = new Scanner(System.in);

    public static void main(String[] args){

//        //this uses a scanner, really good for parsing data
//        System.out.println("Please enter your username");
//        String username = consoleReader.next();
//
//        System.out.println("Please enter your password");
//        String password = consoleReader.next();
//
//        int age = -1;
//        do {
//            age = getAge();
//        }while(age > 0);
//
//
//        System.out.printf("Your username: %s and password: %s\n", username, password);
//        System.out.printf("Your age is %d", age);

        //let's use a BufferedReader, good for reading in a mass of info as a string (even numbers)
        //this is verbose
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);//might not like that there is a scanner using sysin
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//this is verbose

        //this is a little cleaner
        //errors can be thrown if there are two pointers to the sys in
        //all other code is commented out because of
        BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Please enter your name");
            String firstName = readFromConsole.readLine();
            System.out.printf("Your name is %s", firstName);
        }catch(IOException ioe){
            ioe.printStackTrace();//used for debugging and logged to an external file
        }
    }

//    public static int getAge(){
//        int age;
//        try{
//            System.out.println("Please enter your age");
//            age = consoleReader.nextInt();
//        }catch(InputMismatchException ime){
//            age = 0;
//            System.err.println("\nCaught InputMismatchException, don't use a string");
//        } catch(Exception e){
//            age = 0;
//            System.err.println("\nNeeds to be a number");
//        }
//        return age;
//    }
}
