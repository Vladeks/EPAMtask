package com.vladeks.part_first_task_third;


import com.vladeks.part_first_task_second.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciExecutor {



    public static void main(String[] args) {
        int n = 10;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Integer i = 0; i < n; i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();
    }
}
