package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Human;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Start");
//        final Color c = Color.of("0000ff");
//        System.out.println("call to Color successful");
//        final Color cc = Color.BLUE;
//        System.out.println(c.name());
//        System.out.println("end");

        final Human a = Human.create("Vasya", 17);
        final Human b = Human.create("Petya", 22);
        final Human c = Human.create("Vasya", 98);
        for (int i = 0; i < 22; i++) {
            final Human d = Human.create("Vasya" + i, 14 + i);
        }
        final Human alice = Human.create("Alice", 11);
        System.out.println(a == c);
    }
}
