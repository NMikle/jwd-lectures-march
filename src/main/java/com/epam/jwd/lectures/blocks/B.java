package com.epam.jwd.lectures.blocks;

public class B extends A {

    static {
        System.out.println("B static");
    }

    {
        System.out.println("B instance");
    }

    public B() {
        System.out.println("B constructor");
    }
}
