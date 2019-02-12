package com.vladeks;

import java.util.Arrays;

public class StringUtils {
    private Object[] args;

    public StringUtils(Object ...args) {
        this.args = args;
    }

    @Override
    public String toString() {

        String string = "";
        for (Object obj : args) {
            string.concat(obj.toString());
        }
        return string;
    }
}
