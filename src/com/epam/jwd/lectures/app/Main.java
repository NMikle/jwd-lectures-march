package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Human;
import com.epam.jwd.lectures.model.Immutable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int biggerThanCacheUpperLimit = 128;
//        int anotherBiggerThanCacheUpperLimit = 128; //equal

//        final Integer four = new Integer("4");
//        final Integer anotherFour = new Integer("4"); //not equal

//        final Integer four = 4;
//        final Integer anotherFour = 4; // equal

//        final Integer four = 128;
//        final Integer anotherFour = 128; // not equal

//        String s1 = "Hello";
//        String s2 = "Hello"; //equal

//        String s1 = new String("Hello");
//        String s2 = new String("Hello");
//        System.out.println(s1 == s2);//not equal
//        s1 = s1.intern();
//        s2 = s2.intern();
//        System.out.println(s1 == s2);//equal

//        final String s1 = "Orange fox";
//        final String s2 = s1.substring(0, 6);
//        System.out.println(s1);
//        System.out.println(s2);

        final List<Human> people = new ArrayList<>();
        final Human vasya = new Human("Vasya", 12);
        final Human anya = new Human("Anya", 11);

        people.add(anya);
        people.add(vasya);
        final Immutable immutableObject = new Immutable("Hello", vasya, people);

        System.out.println(immutableObject.getC());

        immutableObject.getC().get(0).setSomething(true);

        System.out.println(immutableObject.getC());
    }
}
