package com.epam.jwd.lectures.concurrency;

public class RaceConditionCounter {
    public int count;

    public void increment() {
        count++;
    }
}
