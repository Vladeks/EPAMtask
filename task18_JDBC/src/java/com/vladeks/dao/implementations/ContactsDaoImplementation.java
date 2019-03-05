package com.vladeks.dao.implementations;
import com.vladeks.dao.entities.ContactsEntity;
import com.vladeks.dao.interfaces.ContactsDAO;
import com.vladeks.persistance.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactsDaoImplementation implements ContactsDAO {
    private static final String FIND_ALL = "SELECT * FROM contacts";
    private static final String DELETE = "DELETE FROM contacts WHERE id=?";
    private static final String CREATE = "INSERT contacts (id, tel, email) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE contacts SET tel=?, email=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM contacts WHERE id=?";

    @Override
    public List<ContactsEntity> findAll() throws SQLException {
        List<ContactsEntity> cars = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    ContactsEntity car = new ContactsEntity();
                    car.setId(resultSet.getInt("id"));
                    car.setTel(resultSet.getString("tel"));
                    car.setEmail(resultSet.getString("email"));
                    cars.add(car);
//                    departments.add((ContactsEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return cars;
    }

    @Override
    public ContactsEntity findById(Integer integer) throws SQLException {
        ContactsEntity car=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1,integer.toString());
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    car.setId(resultSet.getInt("id"));
                    car.setTel(resultSet.getString("tel"));
                    car.setEmail(resultSet.getString("email"));
//                    entity=(DepartmentEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return car;
    }

    @Override
    public int create(ContactsEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getTel());
            ps.setString(3,entity.getEmail());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ContactsEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getTel());
            ps.setString(3,entity.getEmail());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setString(1,id.toString());
            return ps.executeUpdate();
        }
    }
}
