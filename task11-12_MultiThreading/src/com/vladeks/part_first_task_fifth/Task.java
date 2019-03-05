package com.vladeks.part_first_task_fifth;

import java.time.LocalTime;
import java.util.Date;

public class Task implements Runnable {

    private long delay;

    public Task(long delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(delay + " " + LocalTime.now());
    }
}
