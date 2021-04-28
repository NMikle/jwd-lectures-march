package com.epam.jwd.space.api.model;

import java.util.Objects;

public class Pilot implements Entity {

    private final Long id;
    private final String name;

    public Pilot(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pilot(String name) {
        this(null, name);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(id, pilot.id) && Objects.equals(name, pilot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
