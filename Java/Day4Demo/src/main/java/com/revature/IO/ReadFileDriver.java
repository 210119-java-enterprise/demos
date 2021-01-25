package com.revature.IO;

import java.io.*;

public class ReadFileDriver {
    public static void main(String[] args) {
        File loremIpsum = new File("src/main/resources/happytext.txt");
        if(!loremIpsum.exists()){
            System.err.println("File does not exist");
            return;
        }
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(loremIpsum));
            String currentLine = reader.readLine();

            while(currentLine!=null){
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            //gross but necessary to avoid memory leaks
            // there exists a syntactically better way (see WriteFileDriver)

            try{
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
