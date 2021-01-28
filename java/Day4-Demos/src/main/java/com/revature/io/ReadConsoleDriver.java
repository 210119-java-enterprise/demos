package com.revature.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //System.in represents input stream from the console


        System.out.println("Please enter your username: ");
        String username=sc.next();

        System.out.println("Please enter your password: ");
        String password=sc.next();








        int age=getAge();
        System.out.printf("the Credentials you provided were: %s and %s\n", username, password);
        System.out.printf("Your Age: %d", age);






    }



    public static int getAge(){
        int age=0;
        //int age;//no default value

            try {
                while(age<1) {
                    System.out.println("Please enter your age: ");
                    age = sc.nextInt();// throw InputMismatchException
                }
            } catch (InputMismatchException ime) {
                System.err.println("NaN");
                ime.printStackTrace();
                //age = getAge();

            } catch(Exception e){
                System.err.println("NaN");
            }


        return age;
    }



}
