package com.example;

public class PlaylistService {

    private SongRepository songRepository;

    // Constructor Injection
    public PlaylistService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void showPlaylist() {

        System.out.println("Playlist Service Started");

        songRepository.showSong();
    }
}