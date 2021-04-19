package com.epam.jwd.lectures.model;

import java.util.Objects;

public class Window implements IdEntity<Window> {

    private Integer id;
    private final String type;

    public Window(String type) {
        this.type = type;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Window o) {
        return this.type.compareTo(o.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return id == window.id && Objects.equals(type, window.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Window{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
