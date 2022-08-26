package com.digitalStreamingSystemSB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Model mapped to a row in the table. [ORM]
@Entity
// MovieActors > EMPLOYEES
@Table(name="MOVIEACTORS")
public class MovieActors {
    //	Uniqueness
    @Id
//	Auto gen Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	ma_id > MA_ID
    @Column(name="MA_ID")
    private int ma_id;
    @Column(name="MOVIE_ID", nullable = false)
    private int movie_id;
    @Column(name="ACTOR_ID", nullable = false)
    private int actor_id;

    public MovieActors() {
    }

    public MovieActors(int ma_id, int movie_id, int actor_id) {
        this.ma_id = ma_id;
        this.movie_id = movie_id;
        this.actor_id = actor_id;
    }

    public int getMa_id() {
        return ma_id;
    }

    public void setMa_id(int ma_id) {
        this.ma_id = ma_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
}
