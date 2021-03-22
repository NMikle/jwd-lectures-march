package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.blocks.A;
import com.epam.jwd.lectures.blocks.C;
import com.epam.jwd.lectures.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnimalService {

    private static final Logger LOGGER = LogManager.getLogger(AnimalService.class);

    public static void saySomething(Animal animal) {
        LOGGER.trace("saySomething entered with {} animal", animal);
        System.out.println(animal.makeSomeNoise());
        LOGGER.info("noise made");
        LOGGER.trace("saySomething ended");
    }

}
