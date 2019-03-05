package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.CarsEntity;
import com.vladeks.dao.interfaces.CarDAO;
import com.vladeks.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CarDaoImplementation implements CarDAO {
    @Override
    public List<CarsEntity> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            Query<CarsEntity> query = session.createQuery("from CarsEntity");
//            for (Object object : query.list()) {
//                System.out.println(object.toString());
//            }
            return query.list();
        }
    }

    @Override
    public CarsEntity findById(Integer integer) {
        return null;
    }

    @Override
    public boolean create(CarsEntity entity) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(CarsEntity entity) {
        try(Session session = HibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(CarsEntity entity) {
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
