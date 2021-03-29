package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.exception.NotARealCat;
import com.epam.jwd.lectures.model.Cat;

import java.util.Comparator;

public interface CatService extends AutoCloseable, Comparator<Cat> {

    void pet(Cat cat) throws NotARealCat;

    void close();

}
