package com.vladeks.first;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship implements Serializable {

    List<Droid> ship = new ArrayList<>();

    @Override
    public String toString() {
        return "Ship{" +
                "ship=" + ship +
                '}';
    }

    public static void main(String[] args) throws Exception {

        Ship input = new Ship();
        input.ship.add(new Droid());
        input.ship.add(new Droid("Sam", 20));
        input.ship.add(new Droid());

        // serialization
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);
        oos.close();

        // de-serialization
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Ship output = (Ship) ois.readObject();
        ois.close();
        System.out.println(output.toString());
    }
}

