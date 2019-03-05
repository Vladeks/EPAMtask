package com.vladeks;

import com.vladeks.dao.entities.CarsEntity;
import com.vladeks.dao.implementations.CarDaoImplementation;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CarsEntity car = new CarsEntity();
        car.setYear(1998);
        car.setModel("Mercedes S-class");

        CarDaoImplementation carDao = new CarDaoImplementation();
        try {
            carDao.create(car);
            carDao.findAll().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
