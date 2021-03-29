package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.Cat;
import com.epam.jwd.lectures.repository.CatStorage;
import com.epam.jwd.lectures.repository.StorageFactory;

public class Main {

    public static void main(String[] args) {

//        Animal mammal = new Animal() {
//            @Override
//            public String makeSomeNoise() {
//                return "sound";
//            }
//
//            @Override
//            public void prepareBeforeNoise() {
//                System.out.println("Hey");
//            }
//        };
//
//        };
//        AnimalService.saySomething(pet);

        CatStorage storage = StorageFactory.newInstance().catStorage();
        storage.add(new Cat("Barsik"));
        storage.add(new Cat("Mikki"));
        final Cat a = new Cat("A");
        storage.add(a);
        a.setReadyToBePetted(true);
        storage.add(new Cat("B"));

//        int k = 3;
//
//        storage.sort(new Comparator<Cat>() {
//            @Override
//            public int compare(Cat o1, Cat o2) {
////                k = 4; !!! IMPOSSIBLE !!!
//                System.out.println(k);
//                return o1.isReadyToBePetted() ? 1 : o2.isReadyToBePetted() ? -1 : 0;
//            }
//        });

//        int b = 8;
//        storage.sort((o1, o2) -> {
////            b =9;     !!! IMPOSSIBLE !!!
//            System.out.println(b);
//            return o1.isReadyToBePetted() ? 1 : o2.isReadyToBePetted() ? -1 : 0;
//        });

//        storage.sort(new Comparator<Cat>() {
//            @Override
//            public int compare(Cat o1, Cat o2) {
//                return compareCats(o1, o2);
//            }
//        });

//        storage.sort((o1, o2) -> compareCats(o1, o2));

        storage.sort(Main::compareCats);

        for (Cat cat : storage) {
            System.out.println(cat);
        }

//        int a = 3;
//        System.out.println(a++);
//        System.out.println(++a);
    }

    private static int compareCats(Cat a, Cat b) {
        return a.isReadyToBePetted() ? 1 : b.isReadyToBePetted() ? -1 : 0;
    }

}
