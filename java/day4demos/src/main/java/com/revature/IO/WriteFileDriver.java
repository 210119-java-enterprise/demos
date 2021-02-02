package com.revature.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.revature.Person;
import com.revature.Role;

public class WriteFileDriver {
    
    public static void main(String[] args) {
        File toWrite = new File("src/main/resources/writeToMe.txt");

        /*
            Try-with-resources
                - automatically closes objects declared as resources (1+)
                - only allows for declaration of resources that implement AutoCloseable interface
        */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toWrite, true))) {
            // The boolean in FileWriter toggles overwrite(false/default)/append(true)
            Person me = new Person(1, "ngamble", "password", Role.TRAINER);
            writer.write("\n" + me.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
