package com.epam.jwd.space.api.model;

public record Pilot(Long id, String name) implements Entity {

    public Pilot(String name) {
        this(null, name);
    }
}
