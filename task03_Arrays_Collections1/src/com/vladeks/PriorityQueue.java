package com.vladeks;

import java.util.Arrays;

public class PriorityQueue <T extends Droid> {
    private static final int INITIAL_CAPACITY = 5;

    private Object[] droids;
    private int size = 0;

    public PriorityQueue() {
        droids = new Object[INITIAL_CAPACITY];
    }

    private void grow(int minCapacity) {
        int oldCapacity = droids.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        droids = Arrays.copyOf(droids, newCapacity);
    }

    public void add(T droid) {
        int i = size;
        if (i >= droids.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            droids[0] = droid;
        else
            siftUp(i, droid);
    }

    public T remove() {
        if(size == 0) {
            return null;
        }
        int s = --size;
        T result = (T) droids[0];
        T x = (T) droids[s];
        droids[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftUp(int k, T x) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = droids[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            droids[k] = e;
            k = parent;
        }
        droids[k] = key;
    }

    @Override
    public String toString() {
        return  Arrays.toString(droids);
    }

    private void siftDown(int k, T x) {
        Comparable<? super T> key = (Comparable<? super T>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = droids[child];
            int right = child + 1;
            if (right < size &&
                    ((Comparable<? super T>) c).compareTo((T) droids[right]) > 0)
                c = droids[child = right];
            if (key.compareTo((T) c) <= 0)
                break;
            droids[k] = c;
            k = child;
        }
        droids[k] = key;


    }

    public static void main(String[] args) {
        PriorityQueue<Droid> queue = new PriorityQueue<>();
        queue.add(new Droid(1));
        queue.add(new Droid(5));
        queue.add(new Droid(3));
        queue.add(new Droid(4));
        queue.add(new Droid(8));
        queue.add(new Droid(7));
        queue.add(new Droid(2));
        System.out.println(queue.toString());
        System.out.println(queue.remove());

        System.out.println(queue.toString());

    }
}
