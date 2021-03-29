package com.epam.jwd.lectures.repository;

public enum SimpleStorageFactory implements StorageFactory {
    INSTANCE;

    private static final ArrayCatStorage ARRAY_CAT_STORAGE = new ArrayCatStorage();

    @Override
    public CatStorage catStorage() {
        return ARRAY_CAT_STORAGE;
    }
}
