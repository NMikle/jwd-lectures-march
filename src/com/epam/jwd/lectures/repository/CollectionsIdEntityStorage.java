package com.epam.jwd.lectures.repository;

import com.epam.jwd.lectures.model.IdEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CollectionsIdEntityStorage<T extends IdEntity<T>> implements GeneralStorage<T> {

    private final List<T> data;
    private int size;

    public CollectionsIdEntityStorage(Collection<T> data) {
        this.data = new ArrayList<>(data);
        this.size = data.size();
    }

    public CollectionsIdEntityStorage() {
        this.data = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public T add(T object) {
        if (object.getId() != null) {
            throw new IllegalArgumentException("Entity id must be null");
        }
        object.setId(++size);
        data.add(object);
        return object;
    }

    @Override
    public T get(int id) {
        return data.get(id - 1);
    }

    @Override
    public T remove(int id) {
        return data.remove(id - 1);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public void sort() {
        Collections.sort(data);
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        data.sort(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
