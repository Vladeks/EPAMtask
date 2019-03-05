package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.EmployeeEntity;
import com.vladeks.dao.interfaces.EmployeeDAO;
import com.vladeks.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDAO {


    @Override
    public List<EmployeeEntity> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity ");
//            for (Object object : query.list()) {
//                System.out.println(object.toString());
//            }
            return query.list();
        }
    }

    @Override
    public EmployeeEntity findById(Integer integer) {
        return null;
    }

    @Override
    public boolean create(EmployeeEntity entity) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(EmployeeEntity entity) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(EmployeeEntity entity) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
