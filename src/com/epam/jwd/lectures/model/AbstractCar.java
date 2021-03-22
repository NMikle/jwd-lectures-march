package com.epam.jwd.lectures.model;

public class AbstractCar implements Car {

    private final Engine engine;

    protected AbstractCar(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void drive() {
        engine.start();
        //todo: logic
    }

    @Override
    public void stop() {
        engine.stop();
    }

    @Override
    public Engine getEngine() {
        return engine;
    }
}
