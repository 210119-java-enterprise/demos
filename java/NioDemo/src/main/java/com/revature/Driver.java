package com.revature;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/*
 * Basic Package Explorer written in Java
 * Leverages Java nio and DateTime packages
 *
 * User Stories:
 * 	- As a User I can read and write files
 * 	- As a User I can create and read from directories
 * 	- As a User I can read Date and Time of file creation
 * 	- As a User I can read Date and Time of last modified
 */

public class Driver {

    public static void main(String[] args) {

        // attempting to write to a file
        Path path = FileSystems.getDefault().getPath("src/main/java/com/revature/example2.txt");
        System.out.println(path);
        try {
            FileChannel fileChannel = FileChannel.open(path,  StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            byte[] array = "hello world".getBytes();
            ByteBuffer bbuffer = ByteBuffer.wrap(array);
            fileChannel.write(bbuffer);
            fileChannel.close();


            fileChannel = FileChannel.open(path,
                    StandardOpenOption.READ);
            ByteBuffer newBuffer = ByteBuffer.allocate((int) fileChannel.size());
            System.out.println(fileChannel.read(newBuffer));
            System.out.println(new String(newBuffer.array(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}