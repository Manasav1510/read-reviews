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
		super();
		this.bookRespository = bookRespository;
		
	}

	@Override
	public void addBook(Book book) {
		bookRespository.save(book);
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		return bookRespository.findByBookId(id);
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

}
