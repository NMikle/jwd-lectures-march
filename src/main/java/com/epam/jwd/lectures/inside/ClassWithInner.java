package com.epam.jwd.lectures.inside;

import com.epam.jwd.lectures.model.Dog;

import java.io.Serializable;

public class ClassWithInner {

    private static String staticInnerField;

    private final String alwaysInitialized;

    public ClassWithInner(String alwaysInitialized) {
        this.alwaysInitialized = alwaysInitialized;
    }

    public abstract class InnerClass extends Dog implements Serializable {

        private static final String constant = "Something";

        private String staticInnerField;

        private String someInnerField;

        public InnerClass() {
            super("name");
        }

        public /*static*/ String innerMethod() { //no static!
            return alwaysInitialized + " from inner";
        }

        public /*static*/ class AnotherInnerClass extends InnerClass {//no static

        }
    }

    public Dog method() {
        final InnerClass obj = new InnerClass() {
            // anonymous class
        };
        obj.someInnerField = "Hello";

        class DogWithinMethod extends Dog {
            public DogWithinMethod(String name) {
                super(name);
            }

            @Override
            public String makeSomeNoise() {
                return "class in method";
            }
        }
        return new DogWithinMethod("Bobik");
    }

    public static void main(String[] args) {
        final ClassWithInner outerObject = new ClassWithInner("something");
//        final InnerClass innerObject = outerObject.new Inner();
    }

    public final class InnerClassNumberTwo extends InnerClass {}

}
