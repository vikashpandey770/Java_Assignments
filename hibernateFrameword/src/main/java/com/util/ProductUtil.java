package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Product;

public class ProductUtil {

	public static Session createSesion() {
	Session session=null;
	
	SessionFactory sf=new Configuration()
			.addAnnotatedClass(Product.class)
			.configure()
			.buildSessionFactory();
	session =sf.openSession();
	
		
		return session;
		
		
	}
}
