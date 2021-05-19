package com.epam.jwd.lectures.pool;

import java.sql.SQLException;

@FunctionalInterface
public interface SqlThrowingConsumer<T> {

    void accept(T t) throws SQLException;

}
