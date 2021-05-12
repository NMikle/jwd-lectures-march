package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.concurrency.StaleCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws ExecutionException {
        System.out.println("program start");

        //first thread creation variant
//        final SimpleRunnable firstRunnable = new SimpleRunnable();
//        final SimpleRunnable secondRunnable = new SimpleRunnable();
//
//        new Thread(firstRunnable).start();
//        new Thread(secondRunnable).start();

        //second thread creation variant
//        final CalculationThread t1 = new CalculationThread(3);
//        final CalculationThread t2 = new CalculationThread(8);
//
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.printf("First result: %d, second result: %d\n", t1.result, t2.result);
//        t1.isAlive() == false //another way to detect thread end

//        race condition
//        final RaceConditionCounter c1 = new RaceConditionCounter();
//        IntStream.range(0, 1_000_000).forEach(i -> c1.increment());
//
//        final RaceConditionCounter c2 = new RaceConditionCounter();
//        IntStream.range(0, 1_000_000).parallel().forEach(i -> c2.increment());
//
//        System.out.printf("First result: %d, second result: %d\n", c1.count, c2.count);

//        stale values
//        final StaleCount staleCount = new StaleCount();
//        final Thread t = new Thread(staleCount);
//        t.start();
//        Thread.sleep(1_000);
//        staleCount.setShouldStop(true);

//        reordering
//        final Thread t1 = new Thread(() -> {
//            a = 1;
//            x = b;
//        });
//        final Thread t2 = new Thread(() -> {
//            b = 1;
//            y = a;
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        System.out.printf("x: %d, y: %d\n", x, y);


        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        final Future<Integer> pendingResult = executorService.submit(() -> 2 + 2);

        System.out.println("result computing");
        if (!pendingResult.isDone()) {
            System.out.println("still computing");
            pendingResult.cancel(true);
        }
        try {
            final Integer operationResult = !pendingResult.isCancelled() ? pendingResult.get() : 0;

            System.out.println("done: " + operationResult);

            executorService.shutdown();
            if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("program end");
//        Thread.currentThread().getState()


//        final List<Long> someData = new ArrayList<>();
//        final List<Long> synchronizedData = Collections.synchronizedList(someData); //uses locks (very bad) -- do not use!!!!!
    }
}
