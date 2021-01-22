package com.revature.io;

import com.revature.models.Person;
import com.revature.models.Role;

import java.io.*;

public class WriteFileDriver {
    public static void main(String[] args) {
        /**
         * try with resources
         *  automatically closes objects declared as resources (more than one is allowed)
         *  only allows for the declaration of resources that implement the AutoClossable interface
         */

        File fileToWrite = new File("src/main/resources/writeme.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite, true))){
            Person me = new Person(23423, "tuan", "lpop", Role.ADMIN);
            writer.write("\n" + me.toString());

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
