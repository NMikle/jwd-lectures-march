package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.exception.NotARealCat;
import com.epam.jwd.lectures.model.Cat;

public interface CatService extends AutoCloseable {

    void pet(Cat cat) throws NotARealCat;

    void close();

}
