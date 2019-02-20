package com.vladeks.first;

import java.io.*;

public class Droid implements Serializable {
    private String name = "Paul";
    private int hp = 10;
    private transient int power = hp*10;

    public Droid() {
    }

    public Droid(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.power = hp * 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", power=" + power +
                '}';
    }

    public static void main(String[] args) throws Exception {

        Droid input = new Droid("Volodya", 10);

        // serialization
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);
        oos.close();

        // de-serialization
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Droid output = (Droid) ois.readObject();
        ois.close();
        System.out.println(output.toString());
    }
}
