package com.epam.jwd.lectures.pool;

import java.sql.SQLException;

@FunctionalInterface
public interface SqlThrowingFunction<T, R> {

    R apply(T t) throws SQLException;

}
