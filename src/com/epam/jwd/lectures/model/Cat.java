package com.epam.jwd.lectures.model;

public class Cat extends Pet implements Comparable<Cat> {

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

    @Override
    public String toString() {
        return "Cat{" +
                "name=" + getName() + ", " +
                "readyToBePetted=" + readyToBePetted +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        final String name = getName();
        final String otherName = o.getName();
        return name.compareTo(otherName);
    }
}
