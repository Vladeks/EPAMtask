package com.vladeks;

import java.util.*;

/*
* Create a class containing two String objects and make it Comparable so that
the comparison only cares about the first String. Fill an array and an ArrayList
with objects of your class by using a custom generator (eg, which generates
pairs of Country-Capital). Demonstrate that sorting works properly. Now
make a Comparator that only cares about the second String and
demonstrate that sorting works properly. Also perform a binary search using
your Comparator.
* */

public class StringPair implements Comparable<StringPair>{

    private String first;
    private String second;

    public StringPair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "StringPair{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }

    @Override
    public int compareTo(StringPair o) {
        return first.compareTo(o.first);
    }

    private static int index = 0;

    public static StringPair generate() {
        String[] capital = {"Lisbon", "Madrid", "Paris", "Berlin", "Warsaw", "Kiev", "Moscow", "Prague", "Rome"};
        String[] country = {"Portugal", "Spain", "France", "Germany", "Poland", "Ukraine", "Russia", "Czech Republic", "Italy"};
        //int index = new Random(System.currentTimeMillis()).nextInt(capital.length);
        if(index >= capital.length) {
            index =0;
        }

        return new StringPair(country[index], capital[index++]);
    }

    public static void main(String[] args) {
        List<StringPair> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(StringPair.generate());
        }
        System.out.println(list.toString());

        list.sort(new StringPairComparator());
        list.sort(StringPair::compareTo);

        System.out.println(list.toString());

        System.out.println(Collections.binarySearch(list, new StringPair("Portugal","Lisbon")));

    }
}
