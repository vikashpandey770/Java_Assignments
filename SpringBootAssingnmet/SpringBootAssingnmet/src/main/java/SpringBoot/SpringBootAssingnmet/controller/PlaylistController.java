package SpringBoot.SpringBootAssingnmet.controller;


import org.springframework.web.bind.annotation.*;

import SpringBoot.SpringBootAssingnmet.entity.Playlist;

import java.util.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private List<Playlist> playlists = new ArrayList<>();

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlists;
    }

    @PostMapping
    public Playlist addPlaylist(@RequestBody Playlist playlist) {

        playlists.add(playlist);

        return playlist;
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(
            @PathVariable int id,
            @RequestBody Playlist playlist) {

        for (Playlist p : playlists) {

            if (p.getId() == id) {
                p.setName(playlist.getName());
                return p;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletePlaylist(@PathVariable int id) {

        playlists.removeIf(p -> p.getId() == id);

        return "Playlist deleted successfully";
    }
}