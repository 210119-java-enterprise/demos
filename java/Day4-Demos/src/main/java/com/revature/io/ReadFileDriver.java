package com.revature.io;

import java.io.*;

public class ReadFileDriver {
    public static void main (String [] args){
        File txt_happy= new File("src/main/resources/happy-text.txt");

        if(!txt_happy.exists()){
            System.err.println("file DNE");
            return;
        }

        BufferedReader reader = null;
        try{
            reader= new BufferedReader(new FileReader(txt_happy));
            String currentLine = reader.readLine();

            while(currentLine!=null){
                System.out.println(currentLine);
                currentLine= reader.readLine();
            }

        }catch(IOException ioe){
            System.err.println("IOException");
        }


        finally {
        try{
            reader.close();
            }

        catch(IOException ioe){
            System.err.println("IOException");
        }


        }


    }
}
