package com.revature;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Basic package explorer written in Java. Leverages Java NIO and DateTime
 * packages
 * 
 * User Stories: 
 *  - As a user, I can read and write files 
 *  - As a user, I can create and read from directories
 *  - As a user, I can read Date and Time of 
 *  - As a user, I can read Date and Time of last modification
 */
public class Driver {

    public static void main(String[] args) {
        String stringPath = "src/main/java/com/revature/resources/output2.txt";
        Path path = FileSystems.getDefault().getPath("src/main/java/com/revature/resources/output2.txt");
        try  {
            // RandomAccessFile reader = new RandomAccessFile(stringPath, "r"); 
            // FileChannel channel = reader.getChannel();
            // ByteArrayOutputStream out = new ByteArrayOutputStream();
            // int bufferSize = 1024;
            // if (bufferSize > channel.size()) {
            //     bufferSize = (int) channel.size();
            // }
            // ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            // while (channel.read(buff) > 0) {
            //     out.write(buff.array(), 0, buff.position());
            //     buff.clear();
            // }

            // String fileContent = new String(out.toByteArray(), StandardCharsets.UTF_8);
            // System.out.println(fileContent);

            
            // Create new file
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            // Writing to file
            Files.write(path, "\nHello therex2".getBytes(), StandardOpenOption.APPEND);

            // Reading from file
            // List<String> stringList = Files.readAllLines(path);
            // Consumer<String> printer = System.out::println;
            Files.readAllLines(path).forEach(System.out::println);

            // Get file attributes
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("File creation time: " + attributes.creationTime());
            System.out.println("Last modified: " + attributes.lastModifiedTime());
            System.out.println("Last accessed: " + attributes.lastAccessTime());
            System.out.println(Files.getAttribute(path, "creationTime"));

            // Create a directory
            Path dirPath = FileSystems.getDefault().getPath("src/main/java/com/revature/resources/test");
            Files.createDirectories(dirPath);

            // Read directories at a path
            Path dirPath2 = FileSystems.getDefault().getPath("src/main/java/com/revature");
            // Consumer<Path> recursivePrintAll = (str ->{
            //     // Path tempPath = FileSystems.getDefault().getPath(str);
            //     if (Files.isDirectory(str)) {
            //         try {
            //             Files.newDirectoryStream(str).forEach(recursivePrintAll);
            //         } catch (IOException e) {
            //             e.printStackTrace();
            //         }
            //     }
            // });
            // Consumer<Path> printAll = (tempPath -> {
            //     System.out.println(tempPath);
            //     BiConsumer<BiConsumer, Path> printHelper = (funct, helperPath) -> {
            //         if (Files.isDirectory(helperPath)) {
            //             try {
            //                 Files.newDirectoryStream(helperPath).forEach((Consumer<Path>) funct);
            //             } catch (IOException e) {
            //                 e.printStackTrace();
            //             }
            //         }
            //     };
            //     printHelper.accept(printHelper, tempPath);
            // });
            Files.newDirectoryStream(dirPath2).forEach(System.out::println);



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
