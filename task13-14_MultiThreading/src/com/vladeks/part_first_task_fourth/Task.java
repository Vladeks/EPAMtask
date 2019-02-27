package com.vladeks.part_first_task_fourth;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Callable<Integer> {

    private Integer n;
    private AtomicInteger sum;

    public Task(Integer n, AtomicInteger sum) {
        this.n = n;
        this.sum = sum;
    }

    public int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


    @Override
    public Integer call() throws Exception {
        synchronized (sum){
            System.out.println(Thread.currentThread().getName() + " " + fibonacci(n));
            return sum.addAndGet(fibonacci(n));
        }
    }
}
