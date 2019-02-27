package com.vladeks.part_first_task_second;

public class Task implements Runnable{

    private Integer n;

    public Task(Integer n) {
        this.n = n;
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
    public void run() {
        synchronized (n){
            System.out.println(Thread.currentThread().getName() + " " + fibonacci(n));
        }
    }

}
