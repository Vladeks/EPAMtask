package com.vladeks.part_first_task_second;


public class Fibonacci {


    public static void main(String[] args) {
        int n = 10;
        for (Integer i = 0; i < n; i++) {
            new Thread(new Task(i)).start();
        }

    }
}
