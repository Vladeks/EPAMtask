package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.AddressEntity;

import java.util.List;

public interface AddressDAO extends AbstractDAO<AddressEntity, Integer> {
    @Override
    List<AddressEntity> findAll();

    @Override
    AddressEntity findById(Integer integer);

    @Override
    boolean create(AddressEntity entity);

    @Override
    boolean update(AddressEntity entity);

    @Override
    boolean delete(AddressEntity entity);
}
