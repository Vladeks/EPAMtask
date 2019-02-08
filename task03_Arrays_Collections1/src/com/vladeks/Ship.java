package com.vladeks;

import java.util.ArrayList;
import java.util.List;

/*
Write your generic class – ship with droids. You can
put and get droids from ship. Try to implement it using
wildcards.
*/

public class Ship <T extends Droid> {
    private List<T> ship;

    public Ship() {
        ship = new ArrayList<>();
    }

    public void putDroid(T droid) {
        ship.add(droid);
    }

    public T getDroid(int index) {
        return ship.get(index);
    }


    public static void main(String[] args) {
        Ship<Droid> ship = new Ship<>();
        ship.putDroid(new Droid());
        ship.putDroid(new Droid());
        ship.putDroid(new Droid());
        System.out.println(ship.getDroid(1));
    }
}
