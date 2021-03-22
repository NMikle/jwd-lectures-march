package com.epam.jwd.lectures.blocks;

public class A {

    static {
        System.out.println("A static");
    }

    {
        System.out.println("A instance");
    }

    public A() {
        System.out.println("A constructor");
    }
}
