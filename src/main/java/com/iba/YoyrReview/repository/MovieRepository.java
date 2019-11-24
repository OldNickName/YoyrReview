package com.iba.YoyrReview.repository;

import com.iba.YoyrReview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Movie findByTitle(String title);

    public List<Movie> findByReleaseDate(Integer releaseDate);

    public List<Movie> findByProducer(String producer);
}
