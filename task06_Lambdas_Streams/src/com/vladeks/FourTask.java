package com.vladeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourTask {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        List<String> list = new ArrayList<>();

        do {
            String line = scanner.nextLine();
            if(line.equals("")) {
                flag = false;
            } else {
                list.add(line);
            }

        } while (flag);

        System.out.println(list.toString());
        findUnique(list);
        sortedListOfUnique(list);
    }

    private static void findUnique(List<String> list) {
        System.out.println("number of unique lines: " + list.stream().distinct().count());
    }

    private static void sortedListOfUnique(List<String> list) {
        System.out.println("Sorted list of unique");
        System.out.println(Arrays.toString(list.stream().distinct().sorted().toArray()));
    }
}
