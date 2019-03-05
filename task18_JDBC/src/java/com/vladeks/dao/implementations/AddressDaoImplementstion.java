package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.AddressEntity;
import com.vladeks.dao.interfaces.AddressDAO;
import com.vladeks.persistance.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImplementstion implements AddressDAO {
    private static final String FIND_ALL = "SELECT * FROM address";
    private static final String DELETE = "DELETE FROM address WHERE ad_id=?";
    private static final String CREATE = "INSERT address (street, city, employee_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE address SET street=?, city=? WHERE ad_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM address WHERE ad_id=?";

    @Override
    public List<AddressEntity> findAll() throws SQLException {
        List<AddressEntity> address = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    AddressEntity car = new AddressEntity();
                    car.setAdId(resultSet.getInt("ad_id"));
                    car.setStreet(resultSet.getString("street"));
                    car.setCity(resultSet.getString("city"));
                    address.add(car);
//                    departments.add((AddressEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return address;
    }

    @Override
    public AddressEntity findById(Integer integer) throws SQLException {
        AddressEntity address=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1,integer.toString());
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    address.setAdId(resultSet.getInt("ad_id"));
                    address.setStreet(resultSet.getString("street"));
                    address.setCity(resultSet.getString("city"));
//                    entity=(DepartmentEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return address;
    }

    @Override
    public int create(AddressEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getAdId());
            ps.setString(2,entity.getStreet());
            ps.setString(3,entity.getCity());
            ps.setInt(4, entity.getEmployee().getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(AddressEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getAdId());
            ps.setString(2,entity.getStreet());
            ps.setString(3,entity.getCity());
            ps.setInt(4, entity.getEmployee().getId());
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
