package com.epam.jwd.lectures.model;

public class ToyCat extends Cat {
    public ToyCat(String name) {
        super(name);
    }

    @Override
    public String makeSomeNoise() {
        return "toy meow";
    }
}
