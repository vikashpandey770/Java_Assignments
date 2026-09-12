package com.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="playlist")
public class Playlist {

	private int pid;
	private String playlistname,totalsong;
	private List<Song> songs;
	
}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="playlist_id")
	@JoinColumn(name="song_id")
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public String getPlaylistname() {
		return playlistname;
	}
	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}
	


	
}
