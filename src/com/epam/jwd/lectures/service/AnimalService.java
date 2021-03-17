package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.model.Animal;

public class AnimalService {

    public static void saySomething(Animal animal) {
        System.out.println(animal.makeSomeNoise());
    }

}
