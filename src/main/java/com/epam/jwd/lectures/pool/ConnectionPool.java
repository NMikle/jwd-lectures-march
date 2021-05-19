package com.epam.jwd.lectures.pool;

import com.epam.jwd.lectures.exception.CouldNotInitializeConnectionPoolException;

import java.sql.Connection;

public interface ConnectionPool {

    Connection takeConnection();

    void releaseConnection(Connection connection);

    void init() throws CouldNotInitializeConnectionPoolException;

    void destroy();

    static ConnectionPool retrieve() {
        return ConcurrentConnectionPool.INSTANCE;
    }

}
