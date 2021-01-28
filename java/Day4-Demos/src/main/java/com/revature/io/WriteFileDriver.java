package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.*;

public class WriteFileDriver {
    public static void main(String[] args) {
        File fileToWrite = new File("src/main/resources/writer.txt");


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true));) {
            Person me = new Person(1, "dsads", "dsads", Role.TRAINER);
            writer.write("\n "+me.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
