package com.digitalStreamingSystemSB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// Model mapped to a row in the table. [ORM]
@Entity
// MovieReview > MOVIE_REVIEW
@Table(name="MOVIE_REVIEW")
public class MovieReview {
    //	Uniqueness
    @Id
    //	Auto gen Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //	id > MOVIE_REVIEW_ID
    @Column(name="REVIEW_ID")
    private int review_id;
    @Column(name="DATE_POSTED", nullable = false)
    private String date_posted;
    @Column(name="DESCRIPTION", nullable = false)
    private String description;
    @Column(name="RATING", nullable = false)
    private int rating;
    @Column(name="MOVIE_ID", nullable = false)
    private int movieId;
    @Column(name="CUSTOMER_ID", nullable = false)
    private int customer_id;

    public MovieReview(int review_id, String date_posted, String description, int rating, int movieId, int customer_id) {
        this.review_id = review_id;
        this.date_posted = date_posted;
        this.description = description;
        this.rating = rating;
        this.movieId = movieId;
        this.customer_id = customer_id;
    }

    public MovieReview() {
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(String date_posted) {
        this.date_posted = date_posted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
