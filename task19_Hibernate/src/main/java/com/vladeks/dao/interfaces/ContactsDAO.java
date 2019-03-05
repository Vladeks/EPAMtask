package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.ContactsEntity;

import java.util.List;

public interface ContactsDAO extends AbstractDAO<ContactsEntity, Integer> {
    @Override
    List<ContactsEntity> findAll();

    @Override
    ContactsEntity findById(Integer integer);

    @Override
    boolean create(ContactsEntity entity);

    @Override
    boolean update(ContactsEntity entity);

    @Override
    boolean delete(ContactsEntity integer);
}
