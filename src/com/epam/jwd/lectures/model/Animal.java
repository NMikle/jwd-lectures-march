package com.epam.jwd.lectures.model;

public interface Animal extends Entity {

    String ANYTHING = "anything";

    String makeSomeNoise();

    default void hello() {
        System.out.println("Hello");
    }

    static void hey() {
        System.out.println("Hey");
    }
}
