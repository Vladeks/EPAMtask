package com.vladeks.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
//            // A SessionFactory is set up once for an application!
//            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                    .configure() // configures settings from hibernate.cfg.xml
//                    .build();
//            try {
//                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//            }
//            catch (Exception e) {
//                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//                // so destroy it manually.
//                StandardServiceRegistryBuilder.destroy( registry );
//
//                throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
//            }
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {

        return getSessionFactory().openSession();
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}