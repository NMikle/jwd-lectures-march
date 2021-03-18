package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Cat;
import com.epam.jwd.lectures.service.AnimalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Program Started");
        AnimalService.saySomething(new Cat("Barsik"));
        LOGGER.info("Program Ended");
    }
}
