package SpringBoot.SpringBootAssingnmet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.SpringBootAssingnmet.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

	List<Song> findByArtist(Song artist);
	
	
	
}
