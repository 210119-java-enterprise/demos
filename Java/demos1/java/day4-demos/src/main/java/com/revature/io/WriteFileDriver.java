package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
    public static void main(String[] args) {

        File fileToWrite = new File("src/main/resources/writeToMe.txt");

        // try with resources
            //java 7
            //automatically closes objects declared as resources
            //only allows for declaration of resources that implement the autocloseable interface

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            Person me = new Person(1, "e", "p", Role.ADMIN);
            writer.write(me.toString() + "/n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
