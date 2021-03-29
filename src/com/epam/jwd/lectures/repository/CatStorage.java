package com.epam.jwd.lectures.repository;

import com.epam.jwd.lectures.model.Cat;

import java.util.Comparator;

public interface CatStorage extends Iterable<Cat> {

    Cat add(Cat cat);

    Cat get(int index);

    Cat remove(int index);

    int size();

    void sort();

    void sort(Comparator<? super Cat> comparator);
}
