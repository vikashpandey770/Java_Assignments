package SpringBoot.SpringBootAssingnmet.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private List<String> movies = new ArrayList<>(
            Arrays.asList(
                    "Avengers",
                    "3 Idiots",
                    "Interstellar"
            )
    );

    @GetMapping
    public List<String> getMovies() {

        return movies;
    }

    @PostMapping
    public String addMovie(@RequestBody MovieRequest request) {

        System.out.println("New movie received: "
                + request.getTitle());

        movies.add(request.getTitle());

        return "Movie added successfully: "
                + request.getTitle();
    }
}