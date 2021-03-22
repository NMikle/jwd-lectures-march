package com.epam.jwd.lectures.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Immutable /*extends Human*/ {

    private final String a;
    private final Human b;
    private final List<Human> c;

    public Immutable(String a, Human b, List<Human> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public Human getB() {
        return copyHuman(b);
    }

    private Human copyHuman(Human humanToCopy) {
        final Human bCopy = new Human(humanToCopy.getName(), humanToCopy.getAge());
        bCopy.setSomething(humanToCopy.isSomething());
        return bCopy;
    }

    public List<Human> getC() {
        final List<Human> cCopy = new ArrayList<>();
        for (Human human : c) {
            cCopy.add(copyHuman(human));
        }
        return cCopy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Immutable immutable = (Immutable) o;
        return Objects.equals(a, immutable.a) && Objects.equals(b, immutable.b) && Objects.equals(c, immutable.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
