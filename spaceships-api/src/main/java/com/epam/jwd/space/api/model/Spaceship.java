package com.epam.jwd.space.api.model;

import java.util.Objects;

public class Spaceship implements Entity {

    private final Long id;
    private final String name;
    private final Integer distance;
    private final Pilot pilot;

    public Spaceship(Long id, String name, Integer distance, Pilot pilot) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.pilot = pilot;
    }

    public Spaceship(String name, Integer distance, Pilot pilot) {
        this(null, name, distance, pilot);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public Pilot getPilot() {
        return pilot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spaceship spaceship = (Spaceship) o;
        return Objects.equals(id, spaceship.id) &&
                Objects.equals(name, spaceship.name) &&
                Objects.equals(distance, spaceship.distance) &&
                Objects.equals(pilot, spaceship.pilot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, distance, pilot);
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", pilot=" + pilot +
                '}';
    }
}
