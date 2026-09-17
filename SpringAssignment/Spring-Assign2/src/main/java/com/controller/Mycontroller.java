package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Mycontroller {


    // GET request
    @GetMapping("/addSong.action")
    public String showAddSongForm(ModelMap model) {

        prepareModel(model);

        return "addSong";
    }


    // POST request
    @PostMapping("/saveSong.action")
    public String saveSong(
            @RequestParam("songName") String songName,
            @RequestParam("artist") String artist,
            ModelMap model) {

        prepareModel(model);

        model.addAttribute("songName", songName);
        model.addAttribute("artist", artist);

        return "confirmation";
    }


    // Common logic
    private void prepareModel(ModelMap model) {

        model.addAttribute("title", "Playlist Song");

    }
}