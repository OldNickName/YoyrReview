package com.iba.YoyrReview.service;

import com.iba.YoyrReview.entity.Movie;
import com.iba.YoyrReview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class MovieService implements MovieRepository {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findByTitle(String title) {
        Movie movie = new Movie();
            movie = movieRepository.findByTitle(title);
            return movie;
    }

    @Override
    public List<Movie> findByReleaseDate(Integer releaseDate) {
        List<Movie> movieList = new ArrayList<>();
        movieList = movieRepository.findByReleaseDate(releaseDate);
        return movieList;
    }

    @Override
    public List<Movie> findByProducer(String producer) {
        List<Movie> movieList = new ArrayList<>();
        movieList = movieRepository.findByProducer(producer);
        return movieList;
    }
}
