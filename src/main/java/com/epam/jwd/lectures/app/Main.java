package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.AppUser;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");
        registerDrivers();
        try (final Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/testDb", "root", "root");
             final Statement statement = conn.createStatement();
             final ResultSet resultSet = statement.executeQuery("select * from app_user")) {
            while (resultSet.next()) {
                final AppUser user = new AppUser(resultSet.getLong("id"),
                        resultSet.getString("u_name"),
                        resultSet.getInt("u_age"));
                System.out.printf("found user: %s\n", user);
            }
        } catch (SQLException e) {
            System.out.println("user name read unsuccessfully");
            e.printStackTrace();
        }
        deregisterDrivers();
        System.out.println("end");
    }

    private static void registerDrivers() {
        System.out.println("sql drivers registration start...");
        try {
            DriverManager.registerDriver(DriverManager.getDriver("jdbc:mysql://localhost:3306/testDb"));
            System.out.println("registration successful");
        } catch (SQLException e) {
            System.out.println("registration unsuccessful");
            e.printStackTrace();
        }
    }

    private static void deregisterDrivers() {
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
