package com.revature.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {
    //reading input from the console
    static Scanner consoleReader = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Please enter your username: ");
        String username = consoleReader.next();

        System.out.print("Please enter your password: ");
        String password = consoleReader.next();

        System.out.printf("The credentials are %s and %s\n", username, password);

        int age = getAge();

        System.out.printf("Your age is: %d", age);

        //reading from console using bufferedReader

        //concise declaration

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.print("\nPlease enter your first name: ");
            String firstname =consoleReader.readLine();
            System.out.printf("Your first name is: %s", firstname);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static int getAge(){
        int age;
        try{
            System.out.print("Please enter your age: ");
            age = consoleReader.nextInt();

        }catch (Exception e)
        {
            age = 0;
            System.err.println("\nThat's not a number.");

        }
        return age;
    }

}
