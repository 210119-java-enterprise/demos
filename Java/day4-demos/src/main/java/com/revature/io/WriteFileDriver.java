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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))) {
            Person me = new Person(1, "wsdf", "password", Role.TRAINER);
            writer.write("\n" + me.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
