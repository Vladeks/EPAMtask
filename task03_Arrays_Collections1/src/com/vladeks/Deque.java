package com.vladeks;

public class Deque<T> {

    private static final int INITIAL_CAPACITY = 10;

    private Object[] objects;
    int head;
    int tail;

    public Deque() {
        objects = new Object[INITIAL_CAPACITY];
    }

    private void increaseCapacity() {
        assert head == tail;
        int p = head;
        int n = objects.length;
        int r = n - p; // number of elements to the right of p
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] a = new Object[newCapacity];
        System.arraycopy(objects, p, a, 0, r);
        System.arraycopy(objects, 0, a, r, p);
        objects = a;
        head = 0;
        tail = n;
    }

    public void addFirat(T obj) {
        objects[head = (head - 1) & (objects.length - 1)] = obj;
        if (head == tail)
            increaseCapacity();
    }

    public void addLast(T obj) {
        objects[tail] = obj;
        if ( (tail = (tail + 1) & (objects.length - 1)) == head)
            increaseCapacity();
    }

    public T removeFirst() {
        int h = head;
        T result = (T) objects[h];
        if (result == null)
            return null;
        objects[h] = null;
        head = (h + 1) & (objects.length - 1);
        return result;
    }


    public T removeLast() {
        int t = (tail - 1) & (objects.length - 1);
        T result = (T) objects[t];
        if (result == null)
            return null;
        objects[t] = null;
        tail = t;
        return result;
    }

    public T getFirst() {
        return (T) objects[head];
    }

    public T getLast() {
        return (T) objects[(tail - 1) & (objects.length - 1)];
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirat(1);
        deque.addLast(2);
        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.getLast());

    }
}
