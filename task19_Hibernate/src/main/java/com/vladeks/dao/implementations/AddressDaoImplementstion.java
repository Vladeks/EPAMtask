package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.AddressEntity;
import com.vladeks.dao.interfaces.AddressDAO;
import com.vladeks.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressDaoImplementstion implements AddressDAO {
    @Override
    public List<AddressEntity> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            Query<AddressEntity> query = session.createQuery("from AddressEntity");
//            for (Object object : query.list()) {
//                System.out.println(object.toString());
//            }
            return query.list();
        }
    }

    @Override
    public AddressEntity findById(Integer integer) {
        return null;
    }

    @Override
    public boolean create(AddressEntity entity) {
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
    public boolean update(AddressEntity entity) {
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
    public boolean delete(AddressEntity entity) {
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
