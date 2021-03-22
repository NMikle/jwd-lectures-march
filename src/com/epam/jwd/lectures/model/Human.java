package com.epam.jwd.lectures.model;

import java.util.Arrays;
import java.util.Objects;

public final class Human {

    public static final int MIN_AGE = 0;

    public static final int GROWTH_FACTOR = 16;
    private static Human[] cache = new Human[GROWTH_FACTOR];
    private static int cachedPeopleAmount = 0;

    private final String name;
    private final int age;
    private boolean something;

    private Human(String name, int age) {
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

    public static Human create(String name, int age) {
        //assertions caches
        for (int i = 0; i < cachedPeopleAmount; i++) {
            Human human = cache[i];
            if (Objects.equals(human.getName(), name) && human.getAge() == age) {
                return human;
            }
        }
        final Human result = new Human(name, age);
        cache[cachedPeopleAmount] = result;
        cachedPeopleAmount++;
        if (cachedPeopleAmount == cache.length - 1) {
            cache = Arrays.copyOf(cache, cachedPeopleAmount + GROWTH_FACTOR);
        }
        return result;
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
