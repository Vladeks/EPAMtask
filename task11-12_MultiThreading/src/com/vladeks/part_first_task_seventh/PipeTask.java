package com.vladeks.part_first_task_seventh;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class PipeTask {

    public static void main(String[] args) throws IOException {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(outputStream);

        new Thread(() -> {
            try {
                outputStream.write("Message".getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                int data = inputStream.read();
                while ( data != -1) {
                    System.out.println((char) data);
                    data = inputStream.read();
                }
                inputStream.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }).start();
    }
}
