package com.epam.jwd.lectures.model;

public abstract class Pet implements Animal {
    private final String name;

    protected Pet(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public static String staticMethod() {
        return "hey from static method";
    }

    @Override
    public String makeSomeNoise() {
        prepareBeforeNoise();
        return "noise";
    }

    @Override
    public final void prepareBeforeNoise() {
        //todo: some logic
    }

    public final void testMethod() {
        System.out.println("Test method");
        //todo: logic
    }
}
