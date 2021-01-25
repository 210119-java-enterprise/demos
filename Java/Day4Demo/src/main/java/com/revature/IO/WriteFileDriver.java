package com.revature.IO;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {
    public static void main(String[] args) {
        File fileToWrite = new File("src/main/resources/writehere.txt");

        /*

        Try with resources
         - java 7
         - automatically closes objects declared as resources
         */

        //syntactic sugar in comparison to the finally in ReadFileDriver
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))){
            Person me = new Person(1, "yorbey", "password", Role.DEV);
            writer.write("\n" + me.toString());
        }catch(IOException e ){
            e.printStackTrace();
        }

    }
}
