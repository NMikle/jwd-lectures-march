package com.epam.jwd.lectures.inside;

import com.epam.jwd.lectures.app.Main;

public class ClassWithNested {

    private static String staticField;
    private String instanceField;

    public abstract static class NestedClass extends Main implements InterfaceWithNested {
        private static String staticField;

        public void nestedMethod(ClassWithNested outerObject) {
            outerObject.instanceField = "3";
            ClassWithNested.staticField = ClassWithNested.staticMethod();
        }

        public static String nestedStaticMethod() {
            return "Hello";
        }

        public class InnerClass {
            public /*static*/ class InnerNestedClass {}
        }

        public static class NestedNestedClass {}
    }

    private static String staticMethod() {
        return "Hey";
    }

    public static String publicStaticMethod() {
        return "Hey";
    }

    public final static class AnotherNested extends InterfaceWithNested.NestedClass {

    }

    public enum Enumeration {
        FIRST("a"),
        SECOND("b") {
            @Override
            public String getField() {
                return "!" + super.getField() + "!";
            }
        };

        private final String field;

        Enumeration(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }
    }

}
