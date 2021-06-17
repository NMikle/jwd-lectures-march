package com.epam.jwd.space.api.model;

public record Spaceship(Long id, String name, Integer distance, Pilot pilot) implements Entity {

    public Spaceship(String name, Integer distance, Pilot pilot) {
        this(null, name, distance, pilot);
    }

}
