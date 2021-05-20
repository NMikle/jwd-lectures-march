package com.epam.jwd.lectures.dao.api;

import com.epam.jwd.lectures.model.DbEntity;
import com.epam.jwd.lectures.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class CommonDao<T extends DbEntity> implements Dao<T> {

    private static final String FIND_ALL_SQL_TEMPLATE = "select * from %s";
    private static final String FIND_BY_ID_SQL_TEMPLATE = "select * from %s where id = ?";

    private final String tableName;
    private final String findAllSql;
    private final String findByIdSql;

    protected CommonDao(String tableName) {
        this.tableName = tableName;
        this.findAllSql = String.format(FIND_ALL_SQL_TEMPLATE, tableName);
        this.findByIdSql = String.format(FIND_BY_ID_SQL_TEMPLATE, tableName);
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return findEntities(findAllSql);
    }

    @Override
    public Optional<T> findById(Long id) {
        return takeFirstNotNull(findPreparedEntities(statement -> statement.setLong(1, id), findByIdSql));
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    protected List<T> findPreparedEntities(SqlThrowingConsumer<PreparedStatement> preparationConsumer,
                                           String sql) {
        try (final Connection conn = ConnectionPool.retrieve().takeConnection();
             final PreparedStatement statement = conn.prepareStatement(sql)) {
            preparationConsumer.accept(statement);
            try (final ResultSet resultSet = statement.executeQuery()) {
                List<T> entities = new ArrayList<>();
                while (resultSet.next()) {
                    final T entity = mapResultSet(resultSet);
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

    protected List<T> findEntities(String sql) {
        try (final Connection conn = ConnectionPool.retrieve().takeConnection();
             final Statement statement = conn.createStatement()) {
            try (final ResultSet resultSet = statement.executeQuery(sql)) {
                List<T> entities = new ArrayList<>();
                while (resultSet.next()) {
                    final T entity = mapResultSet(resultSet);
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

    protected Optional<T> takeFirstNotNull(List<T> entities) {
        return entities.stream()
                .filter(Objects::nonNull)
                .findFirst();
    }

    protected abstract T mapResultSet(ResultSet resultSet) throws SQLException;
}
