package com.vladeks.part_second_task_first;

import java.util.concurrent.locks.Lock;

public class CriticalClass
{

    private Lock lock;

    public CriticalClass(Lock lock) {
        this.lock = lock;
    }

    public void firstMethod() {
        lock.lock();
        try {
            System.out.println("First method" );
        } finally {
            lock.unlock();
        }
    }

    public void secondMethod() {
        lock.lock();
        try {
            System.out.println("Second method" );
        } finally {
            lock.unlock();
        }
    }

    public void thirdMethod() {
        lock.lock();
        try {
            System.out.println("Third method");
        } finally {
            lock.unlock();
        }
    }
}
