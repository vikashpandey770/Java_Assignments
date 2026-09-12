package com.bean;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	/*
	Two similarities:
Both User-Role and Playlist-Song use @ManyToMany with collection fields such as List<Role> and List<Song>.
Both relationships use a join table to store the association between the two entities.
Two differences:
User-Role represents users and their roles, while Playlist-Song represents playlists and songs.
The join tables and foreign-key columns are different: user_role(user_id, role_id) for User-Role 
and playlist_song(playlist_id, song_id) for Playlist-Song.
	
	 */
	
	 
	
    private int id;
    private String username;
    private List<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}