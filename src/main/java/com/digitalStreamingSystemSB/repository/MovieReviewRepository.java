package com.digitalStreamingSystemSB.repository;

import com.digitalStreamingSystemSB.entity.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

}
