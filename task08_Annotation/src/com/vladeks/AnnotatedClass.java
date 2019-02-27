package com.vladeks;

public class AnnotatedClass {

    private int count;
    @YourAnnotation
    private String name;

    private void foo1() {
        System.out.println("Foo1");
    }

    public String foo2(String string) {
        return string;
    }

    protected int[] foo3(int ...arg) {
        return arg;
    }

}
