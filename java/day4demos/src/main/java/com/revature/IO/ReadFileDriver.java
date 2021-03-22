package com.revature.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
    
    public static void main(String[] args) {
        File happytext = new File("src/main/resources/happyText.txt");

        if (!happytext.exists()) {
            System.err.println("File does not exist!");
            return;
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(happytext));
            String currentLine = reader.readLine();

            while (currentLine != null) {
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            // Gross but necessary to avoid memory leaks (better way in WriteFileDriver.java)
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
