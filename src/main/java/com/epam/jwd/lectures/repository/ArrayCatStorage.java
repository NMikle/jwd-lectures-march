package com.epam.jwd.lectures.repository;

import com.epam.jwd.lectures.model.Cat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayCatStorage implements CatStorage {

    public static final int GROWTH_FACTOR = 16;
    private Cat[] data = new Cat[GROWTH_FACTOR];
    private int storedCatsAmount = 0;

    ArrayCatStorage() {
    }

    @Override
    public Cat add(Cat cat) {
        data[storedCatsAmount] = cat;
        storedCatsAmount++;
        if (storedCatsAmount == data.length - 1) {
            data = Arrays.copyOf(data, storedCatsAmount + GROWTH_FACTOR);
        }
        return cat;
    }

    @Override
    public Cat get(int index) {
        if (index > storedCatsAmount - 1 || index < 0) {
            return null; //todo: or exception
        }
        return data[index];
    }

    @Override
    public Cat remove(int index) {
        if (index > storedCatsAmount - 1 || index < 0) {
            return null;
        }
        final Cat deleted = data[index];
        if (data.length - (index + 1) >= 0) {
            System.arraycopy(data, index + 1, data, index, data.length - (index + 1));
        }
        storedCatsAmount--;
        return deleted;
    }

    @Override
    public int size() {
        return storedCatsAmount;
    }

    @Override
    public void sort() {
        final Cat[] sortedCats = Arrays.copyOf(data, storedCatsAmount);
        Arrays.sort(sortedCats);
        System.arraycopy(sortedCats, 0, data, 0, sortedCats.length);
    }

    @Override
    public void sort(Comparator<? super Cat> comparator) {
        final Cat[] sortedCats = Arrays.copyOf(data, storedCatsAmount);
        Arrays.sort(sortedCats, comparator);
        System.arraycopy(sortedCats, 0, data, 0, sortedCats.length);
    }

    @Override
    public Iterator<Cat> iterator() {
        return new Iterator<Cat>() {
            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < storedCatsAmount;
            }

            @Override
            public Cat next() {
                return data[pointer++];
            }
        };
    }
}
