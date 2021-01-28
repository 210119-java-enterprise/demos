package com.revature.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class buffRead {
    public static void main(String[] args) {
        //------------------------------------------------------------
        //reading input from console using BufferReader
        //verbose declaration


        BufferedReader consoleReader = new BufferedReader((new InputStreamReader(System.in)));
        try {
            System.out.println("name: ");
            String fname = consoleReader.readLine();
            System.out.printf("name is %s ", fname );

            System.out.println("age pl0x: ");
            String strAge = consoleReader.readLine();
            int age = Integer.parseInt(strAge);
            System.out.printf("you will be 40 in %d years", (40-age));

        }catch(IOException | NumberFormatException e) {
            System.err.println("you bad at numbers boy");
            e.printStackTrace();//used for debugging -> usually logged to an external file
        }
    }
}
