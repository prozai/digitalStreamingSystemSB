package com.digitalStreamingSystemSB.controller;

import com.digitalStreamingSystemSB.entity.Movie;
import com.digitalStreamingSystemSB.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieControllerDb {
    // Dependency Injection (spring framework creates the Repository internally and injects the instance into your app
    @Autowired
    private MovieRepository movieRepository;
    //  get all movies in a list
    @GetMapping("displayMovie")
    public List getMovieList() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList;
    }
    //   get movie by finding the movie id
    @GetMapping("displayMovie/{id}")
    public Movie getAdminById(@PathVariable(value="id") Integer id) {
        Movie existingMovie = movieRepository.findById(id).get();//java 8 to use .get() method
        return existingMovie;
    }
    //   add movie details
    @PostMapping("displayMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }
    //   update movie by finding the movie id
    @PutMapping("/displayMovie/{id}")
    public Movie updateMovie(@PathVariable(value="id") Integer id, @RequestBody Movie movie) {
        // fetch the movie
        Movie existingMovie = movieRepository.findById(id).get();
        existingMovie.setMovie_id(id);
        existingMovie.setTitle(movie.getTitle());
//        existingMovie.setMovie_image(movie.getMovie_image());
        existingMovie.setCost(movie.getCost());
        existingMovie.setYear(movie.getYear());
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }
    //   delete movie by finding the movie id
    @DeleteMapping("/displayMovie/{id}")
    public Map<String, Boolean> deleteMovieById(@PathVariable(value="id") Integer id) {
        Movie existingMovie = movieRepository.findById(id).get();//java 8 to use .get() method
        movieRepository.delete(existingMovie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
//    ====================================================================

}
