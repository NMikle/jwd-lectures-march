package com.epam.jwd.space.api.repository;

import com.epam.jwd.space.api.model.Entity;

import java.util.List;

public interface BaseRepository<T extends Entity> {

    T save(T entity);

    T findById(Long id);

    List<T> findAll();

}
