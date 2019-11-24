package com.iba.YoyrReview.controllers;

import com.iba.YoyrReview.entity.Movie;
import com.iba.YoyrReview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yourReview")
public class TestController {

    private final MovieRepository movieRepository;

    @Autowired
    public TestController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "homePage";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Movie movie) {
        return "add-movie";
    }

    @PostMapping("/addmovie")
    public String addMovie(Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }

        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "homePage";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") long id, Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            movie.setId(id);
            return "update-movie";
        }

        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "homePage";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id, Model model) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        movieRepository.delete(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "homePage";
    }
}
