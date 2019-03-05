package com.vladeks.part_first_task_sixth;

public class SixthMain {

    int count;

    public static void main(String[] args) {
        SixthMain sm = new SixthMain();
        new Thread(() -> new CriticalClass(sm).firstMethod()).start();
        new Thread(() -> new CriticalClass(sm).secondMethod()).start();
        new Thread(() -> new CriticalClass(sm).thirdMethod()).start();
    }
}
