package com.revature.io;

public class ReadConsoleDriver {

    //System.in represents the input stream from the console
    //Scanner is particularly useful for parsing input streams
    //static Scanner consoleReader=new Scanner(System.in);

    public static void main(String[] args){
        //Reading input from the console using Scanner class
        //System.out.print("please enter your nsername: ");
        //String username=consoleReader.next();

        System.out.println("please enter your password: ");
        String password= consoleReader.next();

        System.out.println("The credentials you provided were: %s and %s\n", username, password);

        int age=getAge();
        System.out.printf("your age is: %d", age);

        --------------------------------------------------

                Reading
    }
}
