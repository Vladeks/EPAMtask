package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO  extends AbstractDAO<EmployeeEntity, Integer>{
    @Override
    List<EmployeeEntity> findAll();

    @Override
    EmployeeEntity findById(Integer integer);

    @Override
    boolean create(EmployeeEntity entity);

    @Override
    boolean update(EmployeeEntity entity);

    @Override
    boolean delete(EmployeeEntity integer);
}
