package com.revature.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class io {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        String userInput = myScanner.next();

        System.out.println(userInput);
        myScanner.close();

//
//        Scanner myScanner2 = new Scanner(System.in);
//
//        System.out.println("Please enter a number: ");
//        String userInput2 = myScanner.next();
//        System.out.println(userInput2);
//        myScanner.close();
        // Reading input from the console using Bufferedreader

        //Verbose declaration

        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
       // BufferedReader verboseReader = new BufferedReader(inputStreamReader);

        //Concise declaration
//        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            System.out.print("Please enter first name: ");
//            String firstName = consoleReader.readLine();
//            System.out.printf("Your name is %s", firstName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }
}
