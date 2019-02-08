package com.vladeks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MyArray {
    /**
     * Create a container that encapsulates an array of String,
     * and that only adds Strings and gets Strings, so that there are no casting issues during use.
     * If the internal array isn’t big enough for the next add,
     * your container should automatically resize it. In main( ),
     * compare the performance of your container with an ArrayList holding Strings.
     */

    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    private String[] array;

    public MyArray() {
        array = new String[DEFAULT_CAPACITY];
        System.out.println(size);
    }

    public void add(String string) {
        resize();
        array[size++] = string;
    }

    public String get(int index) {
        if(index < array.length){
            return array[index];
        }
        return null;
    }

    private void resize() {
        int diff = Math.round(array.length * 0.3f);
        int bound = array.length - diff;
        if(size > bound) {
            int newLength = array.length + diff;
            array =  Arrays.copyOf(array, newLength);
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add("dsfs");
        myArray.add("dsfsd");
        myArray.add("dsfsd");
        myArray.add("dsfsj");
        myArray.add("dsfsg");
        myArray.add("dsfst");
        myArray.add("dsfsk");
        myArray.add("dsfh");
        myArray.add("dsftd");
        myArray.add("dsgnd");
        myArray.add("dsdfgd");
        myArray.add("dsfjk");
        myArray.get(1);
    }
}
