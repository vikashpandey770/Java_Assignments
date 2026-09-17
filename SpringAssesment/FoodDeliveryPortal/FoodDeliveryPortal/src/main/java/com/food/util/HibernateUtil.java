package com.food.util;
import org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
public final class HibernateUtil { private static SessionFactory sessionFactory; private HibernateUtil(){} public static synchronized SessionFactory getSessionFactory(){ if(sessionFactory==null) sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); return sessionFactory; } }
