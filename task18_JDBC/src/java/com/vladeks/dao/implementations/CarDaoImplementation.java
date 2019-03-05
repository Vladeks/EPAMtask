package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.CarsEntity;
import com.vladeks.dao.interfaces.CarDAO;
import com.vladeks.persistance.ConnectionManager;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImplementation implements CarDAO {

    private static final String FIND_ALL = "SELECT * FROM cars";
    private static final String DELETE = "DELETE FROM cars WHERE id=?";
    private static final String CREATE = "INSERT cars (year, model) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE cars SET year=?, model=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM cars WHERE id=?";

    @Override
    public List<CarsEntity> findAll() throws SQLException {
        List<CarsEntity> cars = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    CarsEntity car = new CarsEntity();
                    car.setId(resultSet.getInt("id"));
                    car.setYear(resultSet.getInt("year"));
                    car.setModel(resultSet.getString("model"));
                    cars.add(car);
//                    departments.add((CarsEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return cars;
    }

    @Override
    public CarsEntity findById(Integer integer) throws SQLException {
        CarsEntity car=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1,integer.toString());
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    car.setId(resultSet.getInt("id"));
                    car.setYear(resultSet.getInt("year"));
                    car.setModel(resultSet.getString("model"));
//                    entity=(DepartmentEntity)new Transformer(DepartmentEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return car;
    }

    @Override
    public int create(CarsEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getYear());
            ps.setString(2,entity.getModel());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(CarsEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getYear());
            ps.setString(2,entity.getModel());
            ps.setInt(3,entity.getId());
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
