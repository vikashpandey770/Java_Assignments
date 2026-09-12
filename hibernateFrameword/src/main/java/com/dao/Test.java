package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Playlist;
import com.bean.Song;

public class Test {

	    public static void main(String[] args) {

	        SessionFactory factory = new Configuration()
	                .configure("hibernate.cfg.xml")
	                .addAnnotatedClass(Playlist.class)
	                .addAnnotatedClass(Song.class)
	                .buildSessionFactory();

	        Session session = factory.openSession();

	        Playlist playlist =
	                session.get(Playlist.class, 1);

	        System.out.println("Playlist loaded");

	        // Abhi Songs ko access nahi kiya
	        System.out.println("Songs abhi fetch nahi hue");

	        // Songs ko access kar rahe hain
	        System.out.println(playlist.getSongs());

	        // Ab LAZY ki wajah se Songs fetch honge

	        session.close();
	        factory.close();
	    }
	}

