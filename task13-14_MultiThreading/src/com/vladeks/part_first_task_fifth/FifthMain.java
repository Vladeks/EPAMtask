package com.vladeks.part_first_task_fifth;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FifthMain {

    public static void main(String[] args) {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(3);
        System.out.println("Start " + LocalTime.now());
        for (int i = 0; i < 10; i++) {
            long delay = (long) (1 + new Random(System.currentTimeMillis()).nextInt(11));
            s.schedule( new Task(delay), delay, TimeUnit.SECONDS);
            //s.schedule( (d) -> System.out.println(d + " " + LocalTime.now()), delay, TimeUnit.SECONDS);
        }
        s.shutdown();


    }

}
