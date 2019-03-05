package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.EmployeeEntity;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO  extends AbstractDAO<EmployeeEntity, Integer>{
    @Override
    List<EmployeeEntity> findAll() throws SQLException;

    @Override
    EmployeeEntity findById(Integer integer) throws SQLException;

    @Override
    int create(EmployeeEntity entity) throws SQLException;

    @Override
    int update(EmployeeEntity entity) throws SQLException;

    @Override
    int delete(Integer id) throws SQLException;
}
