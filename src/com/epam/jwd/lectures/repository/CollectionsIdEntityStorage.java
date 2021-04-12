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

    public CollectionsIdEntityStorage(Collection<T> data) {
        this.data = new ArrayList<>(data);
    }

    public CollectionsIdEntityStorage() {
        this.data = new ArrayList<>();
    }

    @Override
    public T add(T object) {
        Integer maxId = data.stream()
                .map(IdEntity::getId)
                .max(Comparator.naturalOrder())
                .orElse(0);
        object.setId(++maxId);
        data.add(object);
        return object;
    }

    @Override
    public T get(int index) {
        return data.get(index);
    }

    @Override
    public T remove(int index) {
        return data.remove(index);
    }

    @Override
    public int size() {
        return data.size();
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
