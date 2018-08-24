package com.read.reviews.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.read.reviews.entity.Author;


public interface AuthorRepository extends MongoRepository<Author, String> {

}
