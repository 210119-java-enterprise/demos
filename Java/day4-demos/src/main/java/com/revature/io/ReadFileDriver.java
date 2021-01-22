package com.revature.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

    public static void main(String[] args) {
        File happyText = new File("src/main/resources/happy-text.txt");
        if (!happyText.exists()) {
            System.err.println("oh no");
            return;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(happyText));
            String currentLine = reader.readLine();

            while (currentLine != null) {
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
