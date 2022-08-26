package com.digitalStreamingSystemSB.controller;

import com.digitalStreamingSystemSB.entity.MovieReview;
import com.digitalStreamingSystemSB.repository.MovieReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieReviewControllerDb {
    // Dependency Injection (spring framework creates the Repository internally and injects the instance into your app
    @Autowired
    private MovieReviewRepository movieReviewRepository;
    // get all movie reviews in a list
    @GetMapping("/review")
    public List getMovieReview() {
        List<MovieReview> movieReviewList = movieReviewRepository.findAll();
        try {;
            movieReviewList = movieReviewRepository.findAll();
        }catch (NullPointerException e) {
            System.out.println("No movie reviews found");
            //  throw customexception if no movie reviews found
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return movieReviewList;
    }

    @PostMapping("/review")
    public MovieReview createMovieReview(@RequestBody MovieReview movieReview) {
        MovieReview savedMovieReview = movieReviewRepository.save(movieReview);
        return savedMovieReview;
    }

    // get movie review by finding the movie review id
    @GetMapping("/review/{id}")
    public MovieReview getMovieReviewById(@PathVariable(value="id") Integer id) {
        MovieReview existingMovieReview = movieReviewRepository.findById(id).get();//java 8 to use .get() method
        return existingMovieReview;
    }
    // update movie review by finding the movie review id
    @PutMapping("/review/{id}")
    public MovieReview updateMovieReview(@PathVariable(value="id") Integer id, @RequestBody MovieReview movieReview) {
        // fetch the movie review
        MovieReview existingMovieReview = movieReviewRepository.findById(id).get();
        existingMovieReview.setReview_id(id);
        existingMovieReview.setDescription(movieReview.getDescription());
        existingMovieReview.setDate_posted(movieReview.getDate_posted());
        existingMovieReview.setRating(movieReview.getRating());
        existingMovieReview.setDate_posted(movieReview.getDate_posted());
        MovieReview savedMovieReview = movieReviewRepository.save(movieReview);
        return savedMovieReview;
    }
    // delete movie review by finding the movie review id
    @DeleteMapping("/review/{id}")
    public Map<String, Boolean> deleteMovieReviewById(@PathVariable(value="id") Integer id) {
        MovieReview existingMovieReview = movieReviewRepository.findById(id).get();//java 8 to use .get() method
        movieReviewRepository.delete(existingMovieReview);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
