package com.vladeks.part_first_task_first;

public class PingPong {

    int  counter = 0;
    int max = 11;

    public static void main(String[] args) {
        PingPong pp = new PingPong();
        start(pp, "Ping");
        start(pp, "\tPong");
    }

    static void start(PingPong pp, String msg) {
        new Thread(() -> {
            synchronized (pp) {
                while (pp.counter++ < pp.max) {

                    System.out.println(msg + pp.counter);
                    pp.notify();
                    try {
                        if (pp.counter < pp.max)
                            pp.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }


        }).start();
    }
}
