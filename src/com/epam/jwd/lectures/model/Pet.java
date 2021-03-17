package com.epam.jwd.lectures.model;

public abstract class Pet implements Animal {
    private final String name;

    protected Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String makeSomeNoise() {
        return "noise";
    }
}
