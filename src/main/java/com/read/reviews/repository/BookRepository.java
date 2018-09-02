package com.read.reviews.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.read.reviews.entity.Book;

public interface BookRepository extends MongoRepository<Book, String>{

	@Query(value = "{'_id': {$regex : ?0, $options: 'i'}}")
 Optional<Book> findByIsbn(String isbn);

 @Query(value = "{'title': {$regex : ?0, $options: 'i'}}")
 Optional<Book> findByTitle(String title);
 
 @Query(value = "{'authorName': {$regex : ?0, $options: 'i'}}")
 Optional<List<Book>> findByAuthorName(String author);
 
 @Query(value = "{'publisher': {$regex : ?0, $options: 'i'}}")
 Optional<List<Book>> findByPublisher(String author);
 
 @Query(value = "{'$or' : [{'publisher': {$regex : ?0, $options: 'i'},'authorName': {$regex : ?0, $options: 'i'},'title': {$regex : ?0, $options: 'i'},'isbn': {$regex : ?0, $options: 'i'}}]}")
 Optional<List<Book>> findByAuthorNameOrTitleOrPublisherOrIsbn(String searchValue);
	
 void deleteByAuthorNameOrTitleOrPublisher(String authorValue,String titleValue,String publisherValue);

}
