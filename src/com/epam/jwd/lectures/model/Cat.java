package com.epam.jwd.lectures.model;

public class Cat extends Pet {

    private boolean readyToBePetted;

    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSomeNoise() {
        return "meow";
    }

    public boolean isReadyToBePetted() {
        return readyToBePetted;
    }

    public void setReadyToBePetted(boolean readyToBePetted) {
        this.readyToBePetted = readyToBePetted;
    }
}
