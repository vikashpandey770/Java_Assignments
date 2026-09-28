package SpringBoot.SpringBootAssingnmet.controller;

import org.springframework.web.bind.annotation.*;

import SpringBoot.SpringBootAssingnmet.entity.Song;
import SpringBoot.SpringBootAssingnmet.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Add Song
    @PostMapping
    public Song addSong(@RequestBody Song song) {

        return songService.addSong(song);
    }

    // Get All Songs
    @GetMapping
    public Iterable<Song> getAllSongs() {

        return songService.getAllSongs();
    }

    // Delete Song
    @DeleteMapping("/{id}")
    public String deleteSong(@PathVariable Long id) {

        songService.deleteSong(id);

        return "Song deleted successfully";
    }

    // Find songs by artist
    @GetMapping("/artist/{artist}")
    public Iterable<Song> findByArtist(@PathVariable String artist) {

        return songService.findByArtist(artist);
    }
}