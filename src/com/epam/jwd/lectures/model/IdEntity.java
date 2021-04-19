package com.epam.jwd.lectures.model;

public interface IdEntity<E> extends Comparable<E> {
    Integer getId();

    void setId(Integer id);
}
