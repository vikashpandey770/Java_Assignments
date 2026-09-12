package com.bean;

public class Sessiin2Q5 {

	//Restaurant restaurant = new Restaurant();

	// TRANSIENT STATE
	// Object sirf Java memory mein hai.
	// Hibernate Session ise manage nahi kar raha.
	// Database mein abhi save nahi hua.
	//restaurant.setName("The Food House");


	// PERSISTENT STATE
	//Session session = sessionFactory.openSession();
	//Transaction tx = session.beginTransaction();

	//session.persist(restaurant);

	// Ab restaurant Hibernate Session ke andar managed hai.
	// Hibernate is object ko database mein persist karega.
	//tx.commit();
	//session.close();
}
