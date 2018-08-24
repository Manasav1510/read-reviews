package com.read.reviews.service;

import java.util.List;
import java.util.Optional;

import com.read.reviews.entity.Book;

public interface BookService {
	
	public void addBook(Book book); 
	
	public Optional<Book> getBookById(Long id);
	
	public Optional<Book> getBookByTitle(String title);
	
	public List<Book> getBooks();
	
	public Book addBookReview(Book book);
	

}
