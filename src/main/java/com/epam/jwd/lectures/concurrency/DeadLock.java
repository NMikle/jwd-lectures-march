package com.epam.jwd.lectures.concurrency;

public class DeadLock {

    private final Object first = new Object();
    private final Object second = new Object();

    public void firstSecond() {
        synchronized (first) {
            synchronized (second) {
                doSomething();
            }
        }
    }

    //wrong blocking order!
    public void secondFirst() {
        synchronized (second) {
            synchronized (first) {
                doSomethingElse();
            }
        }
    }

    private void doSomething() {
        // logic
    }

    private void doSomethingElse() {
        // some other logic
    }

}
