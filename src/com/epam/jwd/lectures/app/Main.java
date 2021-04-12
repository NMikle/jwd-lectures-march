package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Window;
import com.epam.jwd.lectures.repository.CollectionsIdEntityStorage;
import com.epam.jwd.lectures.repository.GeneralStorage;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        List strings = new ArrayList();
//        strings.add("abcd");
//        strings.add(new Object());
//        strings.add(4);
//        for (Object str : strings) {
//            System.out.println(str);
//        }

        GeneralStorage<Window> windows = new CollectionsIdEntityStorage<>();
        windows.add(new Window("wood"));
        windows.add(new Window("glass"));
        windows.add(new Window("grass"));
        windows.sort();
        for (Window window : windows) {
            System.out.println(window);
        }

        List<Number> numbers = Arrays.asList(3, 2d, 1f, 4L);
        oneMethod(numbers);
        anotherMethod(numbers); //PECS   (Producer Extends; Consumer Super)
    }

    private static <E> List<E> buildList(E... arguments) {
        return Arrays.asList(arguments);
    }

    private static int countListSize(List<?> data) {
        final Object o = data.get(1);
        return data.size();
    }

    private static int oneMethod(List<? extends Number> data) {
        for (Number number : data) {
            System.out.println(number);
        }
        final Number number = data.get(1);
//        data.add(3); //compile error!
        return data.size();
    }

    private static int anotherMethod(List<? super Number> data) {
//        final Object o = data.get(1);
        data.add(3);
        return data.size();
    }

}
