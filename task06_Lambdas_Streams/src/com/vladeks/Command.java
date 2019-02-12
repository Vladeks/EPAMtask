package com.vladeks;

@FunctionalInterface
public interface Command {
    void execute(String str);
}
