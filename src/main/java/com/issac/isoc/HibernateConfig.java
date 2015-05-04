package com.issac.isoc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

/**
 * Created by OPSKMC on 5/4/15.
 */
@Repository
public class HibernateConfig {
    private static SessionFactory sessionFactory = null;
    public HibernateConfig(){
        sessionFactory = getSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null)
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory;
    }
}
