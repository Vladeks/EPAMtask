package com.vladeks;

import java.util.Comparator;

public class StringPairComparator implements Comparator<StringPair> {

    @Override
    public int compare(StringPair o1, StringPair o2) {
        return o1.getSecond().compareTo(o2.getSecond());
    }
}
