package com.vladeks.dao.implementations;

import com.vladeks.dao.entities.ContactsEntity;
import com.vladeks.dao.interfaces.ContactsDAO;
import com.vladeks.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ContactsDaoImplementation implements ContactsDAO {
    @Override
    public List<ContactsEntity> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSession()) {
            Query<ContactsEntity> query = session.createQuery("from ContactsEntity");
//            for (Object object : query.list()) {
//                System.out.println(object.toString());
//            }
            return query.list();
        }
    }

    @Override
    public ContactsEntity findById(Integer integer) {
        return null;
    }

    @Override
    public boolean create(ContactsEntity entity) {
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
    public boolean update(ContactsEntity entity) {
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
    public boolean delete(ContactsEntity entity) {
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
