package com.epam.jwd.lectures.blocks;

public class C extends B {

//    public static final int C_VALUE = 0;

    static {
        System.out.println("C static");
    }

    {
        System.out.println("C instance");
    }

    public C() {
        System.out.println("C constructor");
    }

    {
        System.out.println("C instance 2");
    }
}
