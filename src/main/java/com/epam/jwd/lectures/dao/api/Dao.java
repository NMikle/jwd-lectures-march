package com.epam.jwd.lectures.dao.api;

import com.epam.jwd.lectures.model.DbEntity;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends DbEntity> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    T update(T entity);

    void delete(Long id);

}
