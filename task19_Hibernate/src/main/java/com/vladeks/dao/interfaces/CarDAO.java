package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.CarsEntity;

import java.util.List;

public interface CarDAO extends AbstractDAO<CarsEntity, Integer> {
    @Override
    List<CarsEntity> findAll();

    @Override
    CarsEntity findById(Integer integer);

    @Override
    boolean create(CarsEntity entity);

    @Override
    boolean update(CarsEntity entity);

    @Override
    boolean delete(CarsEntity integer);
}
