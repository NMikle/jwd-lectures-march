package com.epam.jwd.lectures.model;

import java.util.Objects;

public class Department implements Cloneable {

    private final String title;

    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Department clone() {
        try {
            return (Department) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Cloneable!!");
        }
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
