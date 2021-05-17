package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.model.AppUser;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Main {

    private static final String SELECT_USERS_OLDER_THEN = "select * from app_user where u_age > ?";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "u_name";
    private static final String AGE_COLUMN = "u_age";

    public static void main(String[] args) {
        System.out.println("start");
        registerDrivers();
        findUsersOlderThan(24).forEach(System.out::println);
        deregisterDrivers();
        System.out.println("end");
    }

    private static List<AppUser> findUsersOlderThan(int age) {
        try (final Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/testDb", "root", "root");
             final PreparedStatement statement = conn.prepareStatement(SELECT_USERS_OLDER_THEN)) {
            statement.setInt(1, age);
            try (final ResultSet resultSet = statement.executeQuery()) {
                List<AppUser> users = new ArrayList<>();
                while (resultSet.next()) {
                    final AppUser user = new AppUser(resultSet.getLong(ID_COLUMN),
                            resultSet.getString(NAME_COLUMN),
                            resultSet.getInt(AGE_COLUMN));
                    users.add(user);
                }
                return users;
            }
        } catch (SQLException e) {
            System.out.println("user name read unsuccessfully");
            e.printStackTrace();
            return Collections.emptyList();
        }
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
