package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

    public static void main(String[] args) {
        File fileToWrite = new File("src/main/resources/happy-text.txt");

        /*
        * Try-with-resources
        *   -Introduced in Java 7
        *   -Automatically closes objects declared as resources (more than one is allowed)
        *   -only allows for declarations of resources that implement AutoCloseable interface
        *
        */

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true)))
        {
            Person me = new Person(1,"dddd", "pppp", Role.ADMIN);
            writer.write("\n" + me.toString());
        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }



    }
}
