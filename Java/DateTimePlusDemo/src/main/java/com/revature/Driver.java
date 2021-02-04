package com.revature;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

/*
    Basic Package Explorer written in Java
    Leverages Java nio and DateTime packages

    User Stories:
        - As a User I can read and write files
        - As a User I can read from directories
        - As a User I can read Date and Time of file creation
        - As a User I can read Date and Time of last modified
 */

public class Driver {

    public static void main(String[] args) {

        //attempting to write to a file
        Path path = FileSystems.getDefault().getPath("src/main/java/com/revature/newDirectory2");


        //System.out.println(path);
        try {
            // Writing to a file
            //Files.createDirectory(path);
            Path file = FileSystems.getDefault().getPath(path.toString()+"/filename.txt");
            //Files.createFile(file);

            FileChannel writeChannel = FileChannel.open(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            byte[] array = "New String 2: Electric Boogaloo\n".getBytes();
            ByteBuffer bbuffer = ByteBuffer.wrap(array);
            writeChannel.write(bbuffer);

            // Reading to a file
            FileChannel readChannel = FileChannel.open(file, StandardOpenOption.READ);

            ByteBuffer readBuffer = ByteBuffer.allocate(array.length);
            readChannel.read(readBuffer);

            String read = new String(readBuffer.array());

            System.out.println(read);
            System.out.println(Files.readAllLines(path));

            BasicFileAttributes fileAttr = Files.readAttributes(file, BasicFileAttributes.class);

            // Date and time of last file modification
            System.out.println("The file was created "+fileAttr.creationTime());

            // Date and time of last file modification
            System.out.println("The file was last modified "+fileAttr.lastModifiedTime());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
