package com.read.reviews.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.read.reviews.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

}
