package SpringBoot.SpringBootAssingnmet.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import SpringBoot.SpringBootAssingnmet.entity.SongRequest;

@RestController
public class SongsController {


    @PostMapping("/addSong")
    public ResponseEntity<String> addSong(
            @Valid @RequestBody SongRequest request) {

        return ResponseEntity.ok(
                "Song added successfully: " + request.getTitle()
        );
    }


    @PostMapping("/addPlaylist")
    public ResponseEntity<String> addPlaylist() {

        return ResponseEntity.ok(
                "Playlist added successfully"
        );
    }
}