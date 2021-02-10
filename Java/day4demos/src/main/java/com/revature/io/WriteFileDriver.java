package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

    public static void main(String[] args) {

        File fileToWrite = new File("src/main/resources/write-to-me.txt");

        /*
            Try-with-resources
                - Introduced in Java 7
                - Automatically closes objects declared as resources (more than one is allowed)
                - only allows for the declaration of resources that implement the AutoCloseable interface
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))) { // boolean means append
            Person me = new Person(1, "ecorpron", "password", Role.DEV);
            writer.write("\n"+ me .toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
