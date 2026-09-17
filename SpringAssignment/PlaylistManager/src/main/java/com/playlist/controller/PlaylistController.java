package com.playlist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.playlist.model.Playlist;

@Controller
public class PlaylistController {

    private List<Playlist> playlists = new ArrayList<>();

    public PlaylistController() {
        playlists.add(new Playlist(1, "My Favorites", "My favorite songs"));
        playlists.add(new Playlist(2, "Workout Music", "Songs for workout"));
        playlists.add(new Playlist(3, "Chill Vibes", "Relaxing music"));
    }

    // Task 1 - Show playlist list
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPlaylists(Model model) {
        model.addAttribute("playlists", playlists);
        return "playlist-list";
    }

    // Open add playlist form
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm() {
        return "add-playlist";
    }

    // Task 2 + Task 4 - Add playlist and redirect
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePlaylist(@RequestParam("name") String name,
                               @RequestParam("description") String description) {

        int id = playlists.size() + 1;
        playlists.add(new Playlist(id, name, description));

        return "redirect:/";
    }

    // Task 3 - Show single playlist details
    @RequestMapping(value = "/playlist/{id}", method = RequestMethod.GET)
    public String showDetails(@PathVariable("id") int id, Model model) {

        for (Playlist p : playlists) {
            if (p.getId() == id) {
                model.addAttribute("playlist", p);
                return "playlist-details";
            }
        }

        return "redirect:/";
    }
}
