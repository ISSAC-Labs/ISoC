package com.issac.isoc.dao;

import com.issac.isoc.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by OPSKMC on 5/4/15.
 */
public abstract class DAO<T> implements DAOOperations<T> {
    private SessionFactory sessionFactory;
    private ApplicationContext context;
    public DAO(){
        context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        HibernateConfig config = context.getBean(HibernateConfig.class);
        sessionFactory = config.getSessionFactory();
    }

    @Override
    public void saveOrUpdate(T instance) {
        Session session  = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(instance);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Exception while saving object of " + getClass().getName());
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public T getInstance(Integer id) {
        Session session  = sessionFactory.openSession();
        T retrievedInstance = null;
        try{
            session.beginTransaction();
            session.load(retrievedInstance.getClass(),id);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Exception while saving object of " + getClass().getName());
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return retrievedInstance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
