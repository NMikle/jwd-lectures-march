package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.exception.CatNotReadyException;
import com.epam.jwd.lectures.exception.NotARealCat;
import com.epam.jwd.lectures.model.Cat;
import com.epam.jwd.lectures.model.ToyCat;

public class RealCatService implements CatService {

    private static final String CAT_NOT_READY_MSG = "Cat %s isn't ready to be patted";

    @Override
    public void pet(Cat cat) throws NotARealCat {
        if (cat instanceof ToyCat) {
            throw new NotARealCat(String.format("Cat %s is not real", cat.getName()));
        }
        if (!cat.isReadyToBePetted()) {
            throw new CatNotReadyException(String.format(CAT_NOT_READY_MSG, cat.getName()));
        }
        //todo: pet the cat
        System.out.println(cat.makeSomeNoise());
        cat.setReadyToBePetted(false);
    }

    @Override
    public void close() {
        System.out.println("service closed");
    }
}
