package com.vladeks;

import com.vladeks.dao.entities.AddressEntity;
import com.vladeks.dao.entities.CarsEntity;
import com.vladeks.dao.entities.ContactsEntity;
import com.vladeks.dao.entities.EmployeeEntity;
import com.vladeks.dao.implementations.AddressDaoImplementstion;
import com.vladeks.dao.implementations.CarDaoImplementation;
import com.vladeks.dao.implementations.ContactsDaoImplementation;
import com.vladeks.dao.implementations.EmployeeDaoImplementation;
import com.vladeks.dao.interfaces.AddressDAO;
import com.vladeks.dao.interfaces.CarDAO;
import com.vladeks.dao.interfaces.ContactsDAO;
import com.vladeks.dao.interfaces.EmployeeDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

public class Main {
    @PersistenceUnit
    static EntityManager manager;

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDaoImplementation();
//        ContactsDAO contactsDAO = new ContactsDaoImplementation();
//        CarDAO carDAO = new CarDaoImplementation();
//        AddressDAO addressDAO = new AddressDaoImplementstion();
//
//        EmployeeEntity employee = new EmployeeEntity();
//        employee.setFirstName("First");
//        employee.setLastName("Last");
//
//        ContactsEntity contacts = new ContactsEntity();
//        contacts.setEmail("email@gmail.com");
//        contacts.setTel("059877");
//        contactsDAO.create(contacts);
//        employee.setContacts(contacts);
//
//        CarsEntity car = new CarsEntity();
//        car.setModel("BMW5");
//        car.setYear(1999);
//        carDAO.create(car);
//        employee.addCar(car);
//
//        AddressEntity address = new AddressEntity();
//        address.setCity("Lviv");
//        address.setStreet("Shevchenka");
//        address.setEmployee(employee);
//
//
//        employeeDAO.create(employee);
//        addressDAO.create(address);
//        employee.addAddress(address);
        System.out.println(employeeDAO.findAll());



    }
}
