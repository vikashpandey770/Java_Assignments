package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.extra.Playlist;
import com.util.HibernateUtil;

import java.util.List;

public class PlaylistManager {

    SessionFactory factory =
            HibernateUtil.getSessionFactory();


    // =====================================
    // CREATE
    // =====================================

    public void createPlaylist(Playlist playlist) {

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(playlist);

        tx.commit();

        session.close();

        System.out.println("Playlist Created");
    }


    // =====================================
    // READ - BY ID
    // =====================================

    public Playlist getPlaylist(int id) {

        Session session = factory.openSession();

        Playlist playlist =
                session.find(Playlist.class, id);

        session.close();

        return playlist;
    }


    // =====================================
    // READ - ALL
    // =====================================

    public void getAllPlaylists() {

        Session session = factory.openSession();

        Query<Playlist> query =
                session.createQuery(
                        "from Playlist",
                        Playlist.class
                );

        List<Playlist> playlists =
                query.list();

        for (Playlist p : playlists) {

            System.out.println(p);
        }

        session.close();
    }


    // =====================================
    // UPDATE
    // =====================================

    public void updatePlaylist(
            int id,
            String name,
            String description) {

        Session session = factory.openSession();

        Transaction tx =
                session.beginTransaction();

        Playlist playlist =
                session.find(Playlist.class, id);

        if (playlist != null) {

            playlist.setName(name);

            playlist.setDescription(description);

            session.merge(playlist);

            System.out.println(
                    "Playlist Updated"
            );

        } else {

            System.out.println(
                    "Playlist Not Found"
            );
        }

        tx.commit();

        session.close();
    }


    // =====================================
    // DELETE
    // =====================================

    public void deletePlaylist(int id) {

        Session session = factory.openSession();

        Transaction tx =
                session.beginTransaction();

        Playlist playlist =
                session.find(Playlist.class, id);

        if (playlist != null) {

            session.remove(playlist);

            System.out.println(
                    "Playlist Deleted"
            );

        } else {

            System.out.println(
                    "Playlist Not Found"
            );
        }

        tx.commit();

        session.close();
    }


    // TASK 5
    // GET PLAYLISTS BY USER ID
  
    public void getPlaylistsByUserId(int userId) {

        Session session = factory.openSession();

        Query<Playlist> query =
                session.createQuery(
                        "from Playlist where user.id = :userId",
                        Playlist.class
                );

        query.setParameter("userId", userId);

        List<Playlist> playlists =
                query.list();

        System.out.println(
                "Playlists of User ID: " + userId
        );

        for (Playlist p : playlists) {

            System.out.println(
                    p.getName()
            );
        }

        session.close();
    }
}