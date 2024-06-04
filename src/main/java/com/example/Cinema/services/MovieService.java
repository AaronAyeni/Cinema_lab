package com.example.Cinema.services;

import com.example.Cinema.models.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setRating(updatedMovie.getRating());
            existingMovie.setDuration(updatedMovie.getDuration());
            return movieRepository.save(existingMovie);
        } else {
            throw new RuntimeException("Movie not found with id " + id);
        }
    }
    public void deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new RuntimeException("Movie not found with id " + id);
        }
    }
}
