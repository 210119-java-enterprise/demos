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
                - automatically closes objects declared as resouces (more than one is allowed)
                - only allows for the declaration of resources that implements the Autocolsable interface

         */

        // this is better than the one in reader
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))){  // <-- that boolean means to append
        Person me = new Person(1,"wsingleton","password", Role.TRAINER);
        writer.write("\n" + me.toString());

    } catch (IOException ioe){
        ioe.printStackTrace();
    }


    }
}
