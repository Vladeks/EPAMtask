package com.vladeks.dao.interfaces;

import com.vladeks.dao.entities.ContactsEntity;

import java.sql.SQLException;
import java.util.List;

public interface ContactsDAO extends AbstractDAO<ContactsEntity, Integer> {
    @Override
    List<ContactsEntity> findAll() throws SQLException;

    @Override
    ContactsEntity findById(Integer integer) throws SQLException;

    @Override
    int create(ContactsEntity entity) throws SQLException;

    @Override
    int update(ContactsEntity entity) throws SQLException;

    @Override
    int delete(Integer id) throws SQLException;
}
