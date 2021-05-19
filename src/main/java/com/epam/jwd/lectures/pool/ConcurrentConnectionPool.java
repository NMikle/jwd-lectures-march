package com.epam.jwd.lectures.pool;

import com.epam.jwd.lectures.exception.CouldNotInitializeConnectionPoolException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Enumeration;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public enum ConcurrentConnectionPool implements ConnectionPool {
    INSTANCE;

    private static final int INIT_CONNECTIONS_AMOUNT = 8;
    private static final int MAX_CONNECTIONS_AMOUNT = 32;
    private static final int CONNECTIONS_GROW_FACTOR = 4;

    private final AtomicBoolean initialized;
    private final Queue<ProxyConnection> availableConnections;
    private AtomicInteger connectionsOpened;

    ConcurrentConnectionPool() {
        initialized = new AtomicBoolean(false);
        availableConnections = new ArrayDeque<>();
        connectionsOpened = new AtomicInteger(0);
    }

    @Override
    public Connection takeConnection() {
        final Connection connection = availableConnections.poll();
        final int currentOpenedConnections = connectionsOpened.get();
        if (availableConnections.size() <= currentOpenedConnections * 0.25
                && currentOpenedConnections < MAX_CONNECTIONS_AMOUNT) {
            // grow connection pool size
        }
        return connection;
    }

    @Override
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            if (connection instanceof ProxyConnection) {
                availableConnections.add((ProxyConnection) connection);
            }
        }
    }

    @Override
    public void init() throws CouldNotInitializeConnectionPoolException {
        if (initialized.compareAndSet(false, true)) {
            registerDrivers();
            try {
                for (int i = 0; i < INIT_CONNECTIONS_AMOUNT; i++) {
                    final Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/testDb",
                                    "root", "root");
                    final ProxyConnection proxyConnection = new ProxyConnection(connection);
                    availableConnections.add(proxyConnection);
                    //initialize connection
                }
            } catch (SQLException e) {
                e.printStackTrace();
                initialized.set(false);
                throw new CouldNotInitializeConnectionPoolException("failed to open connection", e);
            }
            connectionsOpened.set(INIT_CONNECTIONS_AMOUNT);
        }
    }

    @Override
    public void destroy() {
        if (initialized.compareAndSet(true, false)) {
            for (ProxyConnection conn : availableConnections) {
                try {
                    conn.realClose();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //close not available too
            deregisterDrivers();
        }
    }

    private void registerDrivers() throws CouldNotInitializeConnectionPoolException {
        System.out.println("sql drivers registration start...");
        try {
            DriverManager.registerDriver(DriverManager.getDriver("jdbc:mysql://localhost:3306/testDb"));
            System.out.println("registration successful");
        } catch (SQLException e) {
            System.out.println("registration unsuccessful");
            e.printStackTrace();
            initialized.set(false);
            throw new CouldNotInitializeConnectionPoolException("driver registration failed", e);
        }
    }

    private void deregisterDrivers() {
        System.out.println("sql drivers unregistering start...");
        final Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("unregistering drivers failed");
            }
        }
    }
}
