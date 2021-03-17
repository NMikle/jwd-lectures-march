package com.epam.jwd.lectures.model;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSomeNoise() {
        return "Bark";
    }
}
