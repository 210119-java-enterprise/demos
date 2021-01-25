package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

    public static void main(String[] args) {

        File fileToWrite = new File("src/main/resources/write.txt");

        /*
            Try-with-resources
                - Introduced in Java 7
                - automatically closes objects declared as resources (more than one is allowed)
                - only allows for the declaration of resources that implement the AutoCloseable interface
         */

        // Better way to do what is gross in ReadFileDriver
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            Person me = new Person(1, "alexgooge", "password", Role.TRAINER);
            writer.write("\n" + me.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
