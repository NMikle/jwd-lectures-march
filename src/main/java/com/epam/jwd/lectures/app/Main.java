package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.concurrency.CalculationThread;
import com.epam.jwd.lectures.concurrency.RaceConditionCounter;
import com.epam.jwd.lectures.concurrency.SimpleRunnable;
import com.epam.jwd.lectures.concurrency.StaleSleep;

import java.util.stream.IntStream;

public class Main {

    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws InterruptedException {
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
//        final StaleSleep staleSleep = new StaleSleep();
//        final Thread t = new Thread(staleSleep);
//        t.start();
//        Thread.sleep(1_000);
//        staleSleep.setShouldStop(true);

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

        int a = 4;
        System.out.println("program end");
    }
}
