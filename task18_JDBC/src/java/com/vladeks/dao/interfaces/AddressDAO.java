package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.AddressEntity;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO extends AbstractDAO<AddressEntity, Integer> {
    @Override
    List<AddressEntity> findAll() throws SQLException;

    @Override
    AddressEntity findById(Integer integer) throws SQLException;

    @Override
    int create(AddressEntity entity) throws SQLException;

    @Override
    int update(AddressEntity entity) throws SQLException;

    @Override
    int delete(Integer id) throws SQLException;
}
