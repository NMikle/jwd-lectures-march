package com.epam.jwd.lectures.service;

import com.epam.jwd.lectures.model.Window;
import com.epam.jwd.lectures.repository.GeneralStorage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StorageWindowService implements WindowService {

    private final GeneralStorage<Window> storage;

    public StorageWindowService(GeneralStorage<Window> storage) {
        this.storage = storage;
    }

    @Override
    public List<Window> findAllWindows() {
        if (storage.isEmpty()) {
            return Collections.emptyList();
        }
        List<Window> windows = new LinkedList<>();
        for (Window window : storage) {
            windows.add(window);
        }
        return windows;
    }
}
