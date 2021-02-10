package com.revature.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class ReadFileDriver {

    public static void main(String[] args) {

        File hipsterText = new File("src/main/resources/hipster-text.txt");

        if (!hipsterText.exists()) {
            System.err.println("Oh no! That file doesn't exist!");
            return;
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(hipsterText));
            String currentLine = reader.readLine();

            while (currentLine != null) {
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            // this is gross, but necessary in order to avoid memory leaks
            // but there is a syntactcally cleaner way! (See WriteFileDriver.java)
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
