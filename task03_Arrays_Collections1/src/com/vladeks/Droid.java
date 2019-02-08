package com.vladeks;

import java.util.Random;

public class Droid  implements Comparable<Droid>{
    private static final int BOUND = 5;
    private int power;

    public Droid(int power) {
        this.power = power;

    }

    public Droid() {
        power = new Random(System.currentTimeMillis()).nextInt(BOUND);
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Droid power: " + power;
    }

    @Override
    public int compareTo(Droid o) {
        return Integer.compare(power, o.getPower());
    }
}
