package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.exception.NotARealCat;
import com.epam.jwd.lectures.model.Cat;
import com.epam.jwd.lectures.model.ToyCat;
import com.epam.jwd.lectures.service.CatService;
import com.epam.jwd.lectures.service.RealCatService;

public class Main {

    public static void main(String[] args) {
//        int a = 8;
//        System.out.println(checkInputEightRelationship(8));

//        for (int i = 0; i < 10; i++) {
//            System.out.println("Hey " + i);
//        }
//        String str = "Hello";
//        while (!str.isEmpty()) {
//            str = str.substring(1);
//            System.out.println(str);
//        }
//        str = "World";
//        do {
//            str = str.substring(1);
//            System.out.println(str);
//        } while (!str.isEmpty());

//        checkColor("Hey");

//        final Cat cat = new ToyCat("  Mikki    ");
//        cat.setReadyToBePetted(true);
//        try (CatService service = new RealCatService()) {
//            service.pet(cat);
//            System.out.println("end of try");
//        } catch (NotARealCat e) {
//            System.out.println("You've tried to pet toy cat");
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("Hey from finally");
//        }
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static String checkInputEightRelationship(int input) {
        return input > 8
                ? test()
                : input < 8 ? "input fewer than eight" : "input is eight";
    }

    private static String test() {
        System.out.println("wow");
        return "";
    }

    private static void checkColor(String input) {
        switch (input) {
            case "":
                System.out.println("blue");
            case "Wow":
                System.out.println("red");
                break;
            case "Wow wow":
                System.out.println("green");
                break;
            default:
                System.out.println("unknown color");
                break;
        }
        System.out.println("end of checkColor");
    }
}
