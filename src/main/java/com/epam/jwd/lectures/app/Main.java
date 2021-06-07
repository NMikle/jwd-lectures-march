package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.annotation.SimpleUser;
import com.epam.jwd.lectures.annotation.TalkingUser;
import com.epam.jwd.lectures.annotation.User;

public class Main {
    public static void main(String[] args) {
        final User alice = SimpleUser.newInstance(1, "Alice", "12345");
        System.out.println(alice.getLogin());
        System.out.println(alice.getPassword());
        System.out.println(((TalkingUser) alice).saySomething());
        System.out.println(((TalkingUser) alice).anotherSaySomething());

//        final Class<SimpleUser> clazz = SimpleUser.class;
//        final Method[] simpleUserMethods = clazz.getDeclaredMethods();
//        final Method getPasswordMethod = Arrays.stream(simpleUserMethods)
//                .filter(method -> "getPassword".equals(method.getName()))
//                .findAny()
//                .orElse(null);
//        final Object returnedResult = getPasswordMethod.invoke(alice, null);
//        System.out.println(returnedResult);
    }
}
