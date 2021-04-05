package com.epam.jwd.lectures.model;

import java.util.Objects;

public class Department {

    private final String title;

    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Department{" +
                "title='" + title + '\'' +
                '}';
    }
}
