package com.epam.jwd.lectures.app;

import com.epam.jwd.lectures.exception.CouldNotInitializeConnectionPoolException;
import com.epam.jwd.lectures.model.AppUser;
import com.epam.jwd.lectures.pool.ConnectionPool;
import com.epam.jwd.lectures.dao.api.SqlThrowingConsumer;
import com.epam.jwd.lectures.dao.api.SqlThrowingFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final String SELECT_USERS_OLDER_THEN = "select * from app_user where u_age > ?";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "u_name";
    private static final String AGE_COLUMN = "u_age";
    private static final SqlThrowingFunction<ResultSet, AppUser> APP_USER_MAPPER = resultSet ->
            new AppUser(resultSet.getLong(ID_COLUMN),
                    resultSet.getString(NAME_COLUMN),
                    resultSet.getInt(AGE_COLUMN));

    public static void main(String[] args) throws CouldNotInitializeConnectionPoolException {
        System.out.println("start");
        ConnectionPool.retrieve().init();
        findPreparedEntities(whereUserOlderThan(24), APP_USER_MAPPER, SELECT_USERS_OLDER_THEN)
                .forEach(System.out::println);
        ConnectionPool.retrieve().destroy();
        System.out.println("end");
    }

    private static <T> List<T> findPreparedEntities(SqlThrowingConsumer<PreparedStatement> preparationConsumer,
                                                    SqlThrowingFunction<? super ResultSet, ? extends T> resultSetMapper,
                                                    String sql) {
        try (final Connection conn = ConnectionPool.retrieve().takeConnection();
             final PreparedStatement statement = conn.prepareStatement(sql)) {
            preparationConsumer.accept(statement);
            try (final ResultSet resultSet = statement.executeQuery()) {
                List<T> entities = new ArrayList<>();
                while (resultSet.next()) {
                    final T entity = resultSetMapper.apply(resultSet);
                    entities.add(entity);
                }
                return entities;
            }
        } catch (SQLException e) {
            System.out.println("user name read unsuccessfully");
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static SqlThrowingConsumer<PreparedStatement> whereUserOlderThan(int age) {
        return statement -> statement.setInt(1, age);
    }
}
