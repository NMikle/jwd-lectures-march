package com.epam.jwd.lectures.concurrency;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.printf("Hello from thead %s\n", Thread.currentThread().getName());
    }
}
