package com.vladeks.dao.interfaces;

import java.util.List;

public interface AbstractDAO<T, ID> {
    List<T> findAll();

    T findById(ID id);

    boolean create(T entity);

    boolean update(T entity);

    boolean delete(T entity);
}
