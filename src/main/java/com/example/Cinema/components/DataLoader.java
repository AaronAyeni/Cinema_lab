package com.example.Cinema.components;

import com.example.Cinema.models.Movie;
import com.example.Cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(new Movie("Inception", "PG-13", 148));
        movieRepository.save(new Movie("The Matrix", "R", 136));
        movieRepository.save(new Movie("Interstellar", "PG-13", 169));
    }
}
