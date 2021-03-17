package com.epam.jwd.lectures.model;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSomeNoise() {
        return "meow";
    }
}
