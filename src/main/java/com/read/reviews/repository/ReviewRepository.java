package com.read.reviews.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.read.reviews.entity.Review;


public interface ReviewRepository extends MongoRepository<Review,String>{

}
