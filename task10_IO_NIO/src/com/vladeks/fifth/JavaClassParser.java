package com.vladeks.fifth;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class JavaClassParser {

    private final String fileName;

    public JavaClassParser(String fileName) {
        if(isJavaFile(fileName)) {
            this.fileName = fileName;
        } else {
            this.fileName = this.getClass().getName();
        }
        System.out.println(fileName);
    }

    private boolean isJavaFile(String name) {
        boolean isJavaFile = false;
        if (!name.isEmpty()) {
            String[] parts = name.split(".");
            if(parts.length == 2) {
                if(parts[1].equals("java")) {
                    isJavaFile = true;
                }
            }
        }
        return isJavaFile;
    }



    public static void main(String[] args) {
//        E:\Projects\EPAMtask\12.IO_NIO\src\com\vladeks\Main.java
        try {
            List<String> list = new ArrayList<>();
            Files.lines(Paths.get(new Scanner(System.in).nextLine()))
                    .forEach(list::add);

            for (int i = 0; i < list.size(); i++) {
                String line = list.get(i).trim();
                if (line.startsWith("//")) {
                    System.out.println(line);
                } else if (line.startsWith("/*")) {
                    String sub;
                    do{
                        sub = list.get(i++).trim();
                        System.out.println(sub);
                    } while (!sub.endsWith("*/"));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
