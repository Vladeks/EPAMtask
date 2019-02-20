package com.vladeks.sixth;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DirContent {
    public static void readFiles(File baseDirectory){
        if (baseDirectory.isDirectory()){
            for (File file : baseDirectory.listFiles()) {
                if(file.isFile()){
                    System.out.println(file.getName() + " файл");

                }else {
                    System.out.println(file.getName() + " каталог");
                    readFiles(file);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //E:\Projects\EPAMtask\12.IO_NIO\src\com\vladeks
//        new Scanner(System.in).nextLine()
        //readFiles(new File("E:\\Projects\\EPAMtask\\12.IO_NIO\\src\\com\\vladeks"));


        Files.walk(Paths.get("E:\\Projects\\EPAMtask\\12.IO_NIO\\src\\com\\vladeks"), FileVisitOption.FOLLOW_LINKS)
                .map(Path::toFile)
                .forEach(f -> {
                    System.out.println(f.getAbsolutePath() +
                            (f.isDirectory() ? " каталог " : " файл ") +
                            (f.isHidden() ? " hidden " : " not hidden ") +
                            (f.canExecute() ? " can execute " : "cannot execute") +
                            (f.canRead() ? " can read " : "cannot read ") +
                            (f.canWrite() ? " can write " : "cannot write ") +
                            (f.length() + "b")
                    );
                });

    }
}
