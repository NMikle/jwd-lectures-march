package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Animal;
import com.epam.jwd.lectures.model.Cat;
import com.epam.jwd.lectures.model.Dog;
import com.epam.jwd.lectures.model.Human;

public class Main {
    public static void main(String[] args) {
//        final Object vasya = new Human("Vasya", 11);
//        System.out.println(vasya);
//        Object

//        final Animal cat = createCat();
//        final Animal dog = createDog();
//
//        AnimalService.saySomething(cat);
//        AnimalService.saySomething(dog);

        final Human boris = new Human("Boris", 12);
        final Human boris2 = new Human("Boris", 12);
        final Human katya = new Human("Katya", 33);
        System.out.println(boris.hashCode());
        System.out.println(boris2.hashCode());

        byte a = 017;
        short b = 0xAF;
        int c;
        long d;

        float e = 1.0f;
        double f = 2.0;

        boolean g = false;

        char h = '\u0000';
    }

    private static Animal createDog() {
        return new Dog("Sharik");
    }

    private static Animal createCat() {
        return new Cat("Barsik");
    }
}
