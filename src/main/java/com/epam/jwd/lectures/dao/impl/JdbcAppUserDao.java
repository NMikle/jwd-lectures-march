package com.epam.jwd.lectures.dao.impl;

import com.epam.jwd.lectures.dao.api.AppUserDao;
import com.epam.jwd.lectures.dao.api.CommonDao;
import com.epam.jwd.lectures.model.AppUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcAppUserDao extends CommonDao<AppUser> implements AppUserDao {

    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "u_name";
    private static final String AGE_COLUMN = "u_age";
    private static final String TABLE_NAME = "app_user";

    private final String findByNameSql;

    public JdbcAppUserDao() {
        super(TABLE_NAME);
        this.findByNameSql = String.format("select * from %s where %s = ?", TABLE_NAME, NAME_COLUMN);
    }

    @Override
    public Optional<AppUser> findUserByName(String name) {
        return takeFirstNotNull(findPreparedEntities(statement -> statement.setString(1, name), findByNameSql));
    }

    @Override
    protected AppUser mapResultSet(ResultSet resultSet) throws SQLException {
        return new AppUser(resultSet.getLong(ID_COLUMN),
                resultSet.getString(NAME_COLUMN),
                resultSet.getInt(AGE_COLUMN));
    }
}
