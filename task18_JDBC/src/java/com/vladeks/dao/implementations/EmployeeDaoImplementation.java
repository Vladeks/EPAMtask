package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.EmployeeEntity;
import com.vladeks.dao.entities.EmployeeEntity;
import com.vladeks.dao.interfaces.EmployeeDAO;
import com.vladeks.persistance.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDAO {

    private static final String FIND_ALL = "SELECT * FROM employee";
    private static final String DELETE = "DELETE FROM employee WHERE id=?";
    private static final String CREATE = "INSERT employee (firstName, lastName, contacts_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET firstName=?, lastName=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM employee WHERE id=?";

    @Override
    public List<EmployeeEntity> findAll() throws SQLException {
        List<EmployeeEntity> cars = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    EmployeeEntity car = new EmployeeEntity();
                    car.setId(resultSet.getInt("id"));
                    car.setFirstName(resultSet.getString("firstName"));
                    car.setLastName(resultSet.getString("lastName"));
                    cars.add(car);
//                    departments.add((EmployeeEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return cars;
    }

    @Override
    public EmployeeEntity findById(Integer integer) throws SQLException {
        EmployeeEntity car=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1,integer.toString());
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    car.setId(resultSet.getInt("id"));
                    car.setFirstName(resultSet.getString("firstName"));
                    car.setLastName(resultSet.getString("lastName"));
//                    entity=(DepartmentEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return car;
    }

    @Override
    public int create(EmployeeEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getFirstName());
            ps.setString(3,entity.getLastName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(EmployeeEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getFirstName());
            ps.setString(3,entity.getLastName());
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
