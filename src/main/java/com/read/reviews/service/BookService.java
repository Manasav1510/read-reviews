package com.read.reviews.service;

import java.util.List;
import java.util.Optional;

import com.read.reviews.entity.Book;

public interface BookService {
	
	public void addBook(Book book); 
	
	public Optional<Book> getBookByIsbn(String isbn);
	
	public Optional<Book> getBookById(String isbn);
	
	public Optional<Book> getBookByTitle(String title);
	
	public Optional<List<Book>> getBookByAuthorName(String author);
	
	public Optional<List<Book>> getBookByPublisher(String author);
	
	public List<Book> getBooks();
	
	public Book addBookReview(Book book);
	
	public Optional<List<Book>> searchBookByAuthorOrTitleOrPublisherOrIsbn(String searchValue);
	
	public void deleteBook(String value);
	
	public void deleteAllBook();

}
