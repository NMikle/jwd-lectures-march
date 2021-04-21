package com.epam.jwd.lectures.repository;

import com.epam.jwd.lectures.model.IdEntity;

import java.util.Comparator;

public interface GeneralStorage<T extends IdEntity<T>> extends Iterable<T> {

    T add(T object);

    T get(int id);

    T remove(int index);

    int size();

    boolean isEmpty();

    void sort();

    void sort(Comparator<? super T> comparator);
}
