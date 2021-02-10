package com.english.dao;

import com.english.model.Model;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends Model> {

    Optional<T> findById(Long id) throws DAOException;

    List<T> findAll();

    void add(T entity) throws DAOException;

    void update(T entity);

    void delete(T entity);
}
