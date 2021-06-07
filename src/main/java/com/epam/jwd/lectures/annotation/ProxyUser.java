package com.epam.jwd.lectures.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyUser implements InvocationHandler {

    private final User user;

    public ProxyUser(User user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("Trying to invoke method %s\n", method.getName());
        final Class<?> methodsClass = method.getDeclaringClass();
        for (Class<?> interf : user.getClass().getInterfaces()) {
            if (methodsClass.isAssignableFrom(interf)) {
                try {
                    return method.invoke(user, args);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            }
        }
        if (method.isAnnotationPresent(Talk.class)) {
            final Talk talk = method.getAnnotation(Talk.class);
            for (int i = 0; i < talk.value(); i++) {
                System.out.println(talk.text());
            }
            if (method.getReturnType().equals(String.class)) {
                return talk.text();
            }
        } else {
            if (method.getReturnType().equals(String.class)) {
                return "Method not implemented!!!";
            } else {
                System.out.println("Method not implemented!!!");
            }
        }
        return null;
    }
}
