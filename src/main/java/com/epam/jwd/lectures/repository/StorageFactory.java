package com.epam.jwd.lectures.repository;

public interface StorageFactory {

    CatStorage catStorage();

    static StorageFactory newInstance() {
        return SimpleStorageFactory.INSTANCE;
    }

}
