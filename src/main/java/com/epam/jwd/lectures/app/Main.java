package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.inside.ClassWithInner;
import com.epam.jwd.lectures.inside.ClassWithNested;

import static com.epam.jwd.lectures.inside.ClassWithNested.NestedClass.nestedStaticMethod;

public class Main {

    public static void main(String[] args) {
        final ClassWithInner outerObj = new ClassWithInner("something");
        final ClassWithInner.InnerClassNumberTwo innerObject
                = outerObj.new InnerClassNumberTwo();
        System.out.println(nestedStaticMethod());
        final ClassWithNested.NestedClass nestedAnonymousObj = new ClassWithNested.NestedClass() {
            //no constructor declaration


            @Override
            public void nestedMethod(ClassWithNested outerObject) {
                super.nestedMethod(outerObject);
            }

            class Inner {}
        };

        final ClassWithNested.AnotherNested nestedObj = new ClassWithNested.AnotherNested();

        final ClassWithNested.NestedClass.InnerClass innerObj = nestedAnonymousObj.new InnerClass();
    }
}
