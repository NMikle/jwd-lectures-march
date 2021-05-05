package com.epam.jwd.lectures.concurrency;

public class CalculationThread extends Thread {
    private final int value;
    public int result;

    public CalculationThread(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        result = value * 3;
    }
}
