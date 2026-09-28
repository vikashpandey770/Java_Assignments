package SpringBoot.SpringBootAssingnmet.service;

import org.springframework.stereotype.Service;

import SpringBoot.SpringBootAssingnmet.entity.Song;
import SpringBoot.SpringBootAssingnmet.repository.SongRepository;

@Service
public class SongService {
	 private final SongRepository songRepository;

	    public SongService(SongRepository songRepository) {
	        this.songRepository = songRepository;
	    }

	    // Add Song
	    public Song addSong(Song song) {

	        return songRepository.save(song);
	    }

	    // Get All Songs
	    public Iterable<Song> getAllSongs() {

	        return songRepository.findAll();
	    }

	    // Delete Song
	    public void deleteSong(Long id) {

	        songRepository.deleteById(id);
	    }

	    // Find Songs By Artist
	    public Iterable<Song> findByArtist(String artist) {

	        return songRepository.findByArtist(artist)
	    }

}
