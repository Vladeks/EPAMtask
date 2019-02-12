package com.vladeks;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Calculatable max = (a,b,c) -> IntStream.of(a, b, c).max().getAsInt();
        Calculatable avg = (a, b, c) -> Math.round((float) IntStream.of(a, b, c).average().getAsDouble());
        System.out.println("Max = " + max.calculate(1, 2, 3));
        System.out.println("Average = " + avg.calculate(1, 2, 3));

        callAll();
    }

    public static void callAll() {
        System.out.println("Call All");
        int[] array = generateRandomArray(10, 0, 10);
        System.out.println(Arrays.toString(array));
        calculateMin(array);
        calculateMax(array);
        calculateSum(array);
        calculateAvg(array);
        calculateSumWithReduce(array);
        countBiggerThanAvg(array);
    }

    public static int[] generateRandomArray(int streamSize, int randomNumberOrigin, int randomNumberBound) {
        return new Random(System.currentTimeMillis()).ints(streamSize, randomNumberOrigin, randomNumberBound).toArray();
    }

    public static void calculateMin(int[] array) {

        System.out.println("Min: " + Arrays.stream(array).min().getAsInt());
    }

    public static void calculateMax(int[] array) {
        System.out.println("Max: " + Arrays.stream(array).max().getAsInt());
    }
    public static void calculateAvg(int[] array) {
        System.out.println("Avg: " + Arrays.stream(array).average().getAsDouble());
    }

    public static void calculateSum(int[] array) {
        System.out.println("Sum: " + Arrays.stream(array).sum());
    }

    public static void calculateSumWithReduce(int[] array) {
        System.out.println("Sum with reduce: " + Arrays.stream(array).reduce(0, Integer::sum));
    }

    public static void countBiggerThanAvg(int[] array) {
        System.out.println("Bigger than Avg: " +
                Arrays.stream(array).filter(
                        e -> Double.compare((double) e, Arrays.stream(array).average().getAsDouble()) > 0
                ).count()
        );
    }


}

