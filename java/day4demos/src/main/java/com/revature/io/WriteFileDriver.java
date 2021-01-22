package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

    public static void main(String[] args){
        File fileToWrite = new File("src/main/resources/write_to_me.txt");

        //the boolean appends to the file, implicitly false. if you do not want to overwrite
        //you must explicitly say true
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))){
            Person me = new Person(1, "username", "password", Role.DEV);
            writer.write("\n" + me.toString());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
