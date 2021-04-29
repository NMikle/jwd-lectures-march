package com.epam.jwd.lectures.model;

public class Bike {
    private BikeEngine engine;

    public Bike() {
        this.engine = new BikeEngine();
    }

    public class BikeEngine {
        public void start() {
            System.out.println("Engine started");
        }
    }

    public void drive() {
        engine.start();
    }
}
