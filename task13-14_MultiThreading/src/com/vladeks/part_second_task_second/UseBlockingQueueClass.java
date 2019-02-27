package com.vladeks.part_second_task_second;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UseBlockingQueueClass {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        new Thread(() -> {
            try {
                int count = 0;
                while (count++ < 5){
                    queue.put(LocalDateTime.now().toString());
                    Thread.sleep(3 * 1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int count = 0;
            while (count < 5) {
                String readString = queue.peek();
                if (readString != null) {
                    System.out.println(readString);
                    queue.remove();
                    count++;
                }

            }
        }).start();

    }

}
