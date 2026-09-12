package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Song;


public class songdao {

	public static void main(String args[]) {
		
		SessionFactory session=new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		SessionFactory factory = null;
		Session session1 = factory.openSession();
		session1.beginTransaction();
		
		Song song=new Song();
		
		
		session1.save(song);
		session1.getTransaction().commit();
		session1.close();
		factory.close();
		
		
	}
}
