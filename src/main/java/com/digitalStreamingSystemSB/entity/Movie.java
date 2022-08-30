package com.digitalStreamingSystemSB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Model mapped to a row in the table. [ORM]
@Entity
// Movie > MOVIES
@Table(name="MOVIES")
public class Movie {
    //	Uniqueness
    @Id
//	Auto gen Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	id > MOVIE_ID
    @Column(name="MOVIE_ID")
    private int movie_id;
    @Column(name="TITLE", nullable = false)
    private String title;
    @Column(name="COST", nullable = false)
    private int cost;
    @Column(name="YEAR", nullable = false)
    private int year;
    @Column(name="ACTOR_ID", nullable = false)
    private int actor_id;
    @Column(name="THUMBNAIL")
    private String thumbnail;

    public Movie() {
    }

    public Movie(int movie_id, String title, int cost, int year, int actor_id, String thumbnail) {
        this.movie_id = movie_id;
        this.title = title;
        this.cost = cost;
        this.year = year;
        this.actor_id = actor_id;
        this.thumbnail = thumbnail;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
