package com.vladeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FourTask {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        List<String> list = new ArrayList<>();

        do {
            String line = scanner.nextLine();
            if(line.isEmpty()) {
                flag = false;
            } else {
                list.add(line);
            }

        } while (flag);

        System.out.println(list.toString());
        findUnique(list);
        sortedListOfUnique(list);
        wordCount(list);
        charCount(list);
    }

    private static void findUnique(List<String> list) {
        System.out.println("number of unique words: " + list
                .stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .distinct()
                .count());
    }

    private static void sortedListOfUnique(List<String> list) {
        System.out.println("Sorted list of unique");
        System.out.println(Arrays.toString(list.stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .distinct()
                .sorted()
                .toArray()));
    }

    private static void wordCount(List<String> list) {
        System.out.println("Word count");
        System.out.println(
            list
                .stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .toString()

        );
    }


    private static void charCount(List<String> list) {
        System.out.println("Char count");
        System.out.println(
                list
                        .stream()
                        .flatMap(s -> Stream.of(s.split(" ")))
                        .flatMap(s -> Stream.of(s.split("")))
                        .filter(s -> !Character.isUpperCase(s.charAt(0)))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .toString()

        );
    }

}
