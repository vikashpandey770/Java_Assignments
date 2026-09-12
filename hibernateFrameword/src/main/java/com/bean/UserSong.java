package com.bean;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class UserSong {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;

	    private String email;

	    @OneToMany(
	            mappedBy = "user",
	            cascade = CascadeType.ALL
	    )
	    private List<Playlist> playlists = new ArrayList<>();

	    public UserSong() {
	    }

	    public UserSong(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public List<Playlist> getPlaylists() {
	        return playlists;
	    }

	    public void setPlaylists(List<Playlist> playlists) {
	        this.playlists = playlists;
	    }

	    public void addPlaylist(Playlist playlist) {

	        playlists.add(playlist);

	       // playlist.setUserSong(this);
	    }
}
