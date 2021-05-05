package com.epam.jwd.lectures.concurrency;

public class StaleSleep implements Runnable {
    private volatile boolean shouldStop;
    private int counter;

    public void setShouldStop(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }

    @Override
    public void run() {
        while (!shouldStop) {
            //logic
            counter++;
        }
        System.out.printf("stopped. counter: %d\n", counter);
    }
}
