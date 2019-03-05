package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.CarsEntity;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO extends AbstractDAO<CarsEntity, Integer> {
    @Override
    List<CarsEntity> findAll() throws SQLException;

    @Override
    CarsEntity findById(Integer integer) throws SQLException;

    @Override
    int create(CarsEntity entity) throws SQLException;

    @Override
    int update(CarsEntity entity) throws SQLException;

    @Override
    int delete(Integer id) throws SQLException;
}
