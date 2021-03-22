package com.epam.jwd.lectures.model;

import java.util.Objects;

public final class Human {

    public static final int MIN_AGE = 0;

    private final String name;
    private final int age;
    private boolean something;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSomething() {
        return something;
    }

    public void setSomething(final boolean something) {
        this.something = something;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", something=" + something +
                '}';
    }
}
