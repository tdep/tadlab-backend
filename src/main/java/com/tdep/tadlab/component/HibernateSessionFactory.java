package com.tdep.tadlab.component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    public static Session sessionFactoryBuilder() throws Exception {
        try {
            Session session;
            try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
                session = sessionFactory.openSession();
                return session;
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static Transaction beginTransaction(Session session) throws Exception {
        Transaction transaction;
        return transaction = session.beginTransaction();
    }

    public static void commitTransaction(Transaction transaction) throws Exception {
        transaction.commit();
    }

    public static void closeSession(Session session) throws Exception {
        session.close();
    }
    public static void closeSessionFactory(SessionFactory sessionFactory) throws Exception {
        sessionFactory.close();
    }


}
