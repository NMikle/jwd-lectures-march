package com.epam.jwd.lectures.annotation;

import java.lang.reflect.Proxy;
import java.util.Objects;

public class SimpleUser implements User {

    private final Integer id;
    private final String login;
    private final String password;

    private SimpleUser(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUser that = (SimpleUser) o;
        return Objects.equals(id, that.id)
                && Objects.equals(login, that.login)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static User newInstance(Integer id, String login, String password) {
        return wrapWithProxyObject(new SimpleUser(id, login, password));
    }

    private static User wrapWithProxyObject(User user) {
        return (TalkingUser) Proxy.newProxyInstance(user.getClass().getClassLoader(),
                new Class[]{TalkingUser.class},
                new ProxyUser(user));
    }

    public static int minimalId() {
        return 1;
    }

    public static void printHello() {
        System.out.println("Hello");
    }
}
