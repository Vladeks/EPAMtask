package com.vladeks.part_second_task_first;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SixthMain {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> new CriticalClass(lock).firstMethod()).start();
        new Thread(() -> new CriticalClass(lock).secondMethod()).start();
        new Thread(() -> new CriticalClass(lock).thirdMethod()).start();
    }
}
