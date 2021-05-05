package com.epam.jwd.lectures.concurrency;

public class ImmutableClass {

    private final String immutableString;
    private final int immutableInt;

    public ImmutableClass(String immutableString, int immutableInt) {
        this.immutableString = immutableString;
        this.immutableInt = immutableInt;
    }

    public String getImmutableString() {
        return immutableString;
    }

    public int getImmutableInt() {
        return immutableInt;
    }
}
