package com.vladeks.part_first_task_sixth;

import java.time.LocalTime;

public class CriticalClass
{

    private SixthMain object;

    public CriticalClass(SixthMain object) {
        this.object = object;
    }

    public void firstMethod() {
        synchronized (object) {
            System.out.println("First method" + (object.count+1));
        }
    }

    public void secondMethod() {
        synchronized (object) {
            System.out.println("Second method" + (object.count+2));
        }
    }

    public void thirdMethod() {
        synchronized (object) {
            System.out.println("Third method" + (object.count+3));
        }
    }
}
