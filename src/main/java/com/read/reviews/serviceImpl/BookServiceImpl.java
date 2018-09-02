package com.read.reviews.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.read.reviews.entity.Book;
import com.read.reviews.repository.BookRepository;
import com.read.reviews.service.BookService;


@Service
public class BookServiceImpl implements BookService {
	
	BookRepository bookRespository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRespository) {
		this.bookRespository = bookRespository;
		
	}

	@Override
	public void addBook(Book book) {
		bookRespository.save(book);
	}

	@Override
	public Optional<Book> getBookByIsbn(String isbn) {
		return bookRespository.findByIsbn(isbn);
	}

	@Override
	public List<Book> getBooks() {
		return bookRespository.findAll();
	}

	@Override
	public Book addBookReview(Book book) {
		return bookRespository.save(book);
	}

	@Override
	public Optional<Book> getBookByTitle(String title) {
		return bookRespository.findByTitle(title);
	}

	@Override
	public Optional<List<Book>> searchBookByAuthorOrTitleOrPublisherOrIsbn(String searchValue) {
		return bookRespository.findByAuthorNameOrTitleOrPublisherOrIsbn(searchValue);
	}

	@Override
	public void deleteBook(String value) {
			bookRespository.deleteByAuthorNameOrTitleOrPublisher(value,value,value);
			
	}

	@Override
	public void deleteAllBook() {
		bookRespository.deleteAll();
		
	}

	@Override
	public Optional<List<Book>> getBookByAuthorName(String author) {
		return bookRespository.findByAuthorName(author);
	}

	@Override
	public Optional<List<Book>> getBookByPublisher(String publisher) {
		return bookRespository.findByPublisher(publisher);
	}

	@Override
	public Optional<Book> getBookById(String isbn) {
		return bookRespository.findById(isbn);
	}
	
	
	

}
