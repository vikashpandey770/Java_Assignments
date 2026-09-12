package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Util.EmployeeUtil;
import com.bean.EmployeePersonalInfo;
import com.bean.Product;
import com.util.ProductUtil;

public class ProductDao {

	public static void insert(Product p) {
		Session session=ProductUtil.createSesion();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(p);
		tr.commit();
		session.close();
	}
	
	// show methods
		public static List<Product> getAllPro(){
			Session session=ProductUtil.createSesion();
			List<Product>list=session.createQuery("from Product").list();
			session.close();
			return list;	
		}
		
		// fetch methods
		public static Product getPro(int id) {
			Session session=ProductUtil.createSesion();
			Product p=session.get(Product.class,id);
			session.close();
			return p;
		}
		// delete methods
		public static void delete(int id) {
			Session session=ProductUtil.createSesion();
			
			Transaction tr=session.beginTransaction();
			Product p=session.get(Product.class, id);
			session.delete(p);
			tr.commit();
			session.close();
		}

	
}
