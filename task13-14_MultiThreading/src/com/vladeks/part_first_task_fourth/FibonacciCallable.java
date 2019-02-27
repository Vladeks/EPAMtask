package com.vladeks.part_first_task_fourth;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        AtomicInteger sum = new AtomicInteger(0);
        int n = 10;
        List<Task> command = new ArrayList<>();
        for (Integer i = 0; i < n; i++) {
            command.add(new Task(i, sum));
        }
        List<Future<Integer>> result =service.invokeAll(command);
//        for (Future<Integer> res :
//                result) {
//            System.out.println("sum= " + res.get());
//        }
        System.out.println("\nsum= " + result.stream().max(Comparator.comparing(o -> {
            try {
                return o.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return 0;
        })).get().get());

        service.shutdown();
    }
}
