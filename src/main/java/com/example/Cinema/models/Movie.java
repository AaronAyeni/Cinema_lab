package com.example.Cinema.models;

import jakarta.persistence.*;

@Entity(name = "movies")//tells hibernate what to make a table with
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key serial
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private String rating;

    @Column(name = "duration")
    private int duration;


    // Default constructor
    public Movie() {
    }

    // Constructor with parameters
    public Movie(String title, String rating, int duration) {
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
