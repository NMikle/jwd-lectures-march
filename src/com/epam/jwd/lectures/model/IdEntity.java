package com.epam.jwd.lectures.model;

public interface IdEntity<E> extends Comparable<E> {
    int getId();

    void setId(int id);
}
