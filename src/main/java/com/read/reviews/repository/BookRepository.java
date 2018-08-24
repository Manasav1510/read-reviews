package com.read.reviews.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.read.reviews.entity.Book;

public interface BookRepository extends MongoRepository<Book, String>{
	
	public Optional<Book> findByBookId(Long bookId);
	
	public Optional<Book> findByTitle(String title);

}
