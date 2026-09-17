package com.food.dao;
import java.util.List; import org.hibernate.Session; import org.springframework.stereotype.Repository; import com.food.entity.Restaurant; import com.food.util.HibernateUtil;
@Repository public class RestaurantDAOImpl implements RestaurantDAO { public List<Restaurant> getAllRestaurants(){ try(Session s=HibernateUtil.getSessionFactory().openSession()){ return s.createQuery("select distinct r from Restaurant r left join fetch r.menuItems",Restaurant.class).getResultList(); } } }
