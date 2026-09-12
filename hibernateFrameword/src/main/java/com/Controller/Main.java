package com.Controller;

import com.bean.UserSong;
import com.dao.PlaylistManager;
import com.extra.Playlist;
import com.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        PlaylistManager manager =
                new PlaylistManager();


        // CREATE USER
        UserSong user =
                new UserSong(
                        "Vikash",
                        "vikash@gmail.com"
                );


        // CREATE PLAYLISTS
     
        Playlist p1 =
                new Playlist(
                        "Bollywood Songs",
                        "Best Hindi Songs"
                );

        Playlist p2 =
                new Playlist(
                        "Workout Songs",
                        "Gym and Workout Songs"
                );


        // Set User
        p1.setUser(user);
        p2.setUser(user);


        //  user.addPlaylist(p1);
      //  user.addPlaylist(p2);

        // SAVE USER + PLAYLISTS
        var session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();
        var tx =
                session.beginTransaction();

        session.persist(user);

        tx.commit();

        session.close();

        System.out.println(
                "User and Playlists Created"
        );
        // READ ALL
        manager.getAllPlaylists();
        // READ BY ID
        Playlist playlist =
                manager.getPlaylist(1);

        System.out.println(
                "Single Playlist:"
        );

        System.out.println(playlist);
        // UPDATE
        manager.updatePlaylist(
                1,
                "Updated Bollywood Songs",
                "Updated Hindi Songs"
        );
        // USER ID SE PLAYLIST
        manager.getPlaylistsByUserId(1);
        // DELETE
        manager.deletePlaylist(2);
    }
}