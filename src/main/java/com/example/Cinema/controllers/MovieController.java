package com.example.Cinema.controllers;

import com.example.Cinema.models.Movie;
import com.example.Cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) Integer maxDuration) {
        List<Movie> movies;
        if (maxDuration == null){
            movies = movieService.getAllMovies();
        } else {
            movies = movieService.filterMoviesByDuration(maxDuration);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> movie = movieService.getMovieById(id);

        if(movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        try {
            Movie updated = movieService.updateMovie(id, updatedMovie);
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            movieService.deleteMovie(id);
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
         movieService.createMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
}
