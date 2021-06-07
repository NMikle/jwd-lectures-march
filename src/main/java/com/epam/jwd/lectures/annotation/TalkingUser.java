package com.epam.jwd.lectures.annotation;

public interface TalkingUser extends User {

    @Talk(3)
    String saySomething();

    String anotherSaySomething();

}
