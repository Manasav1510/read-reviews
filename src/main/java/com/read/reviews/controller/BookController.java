package com.read.reviews.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.read.reviews.entity.Book;
import com.read.reviews.entity.Review;
import com.read.reviews.exception.ResourceNotFoundException;
import com.read.reviews.model.BookModel;
import com.read.reviews.service.BookService;


@RestController
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@PostMapping(value="/books")
	public int addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return HttpServletResponse.SC_OK;
	}
	
	@GetMapping(value="/books")
	public @ResponseBody Iterable<Book> getBooks(){
		return bookService.getBooks();
		
	}
	
	@GetMapping(value="/books/{bookId}")
	public Book getBook(@PathVariable Long bookId){
		return bookService.getBookById(bookId).orElseThrow(()->new ResourceNotFoundException("Book","id", bookId));
	}
	
	@PutMapping(value="/books/addReview}")
	public Book addBookReview(@RequestBody BookModel model){
		Book bookFound = null;
		Book updatedBook = null;
		if(model.getBookId()!=null) {
			bookFound = bookService.getBookById(model.getBookId()).orElseThrow(()->new ResourceNotFoundException("Book","id", model.getBookId()));
		}else if(model.getBookTitle()!=null && !model.getBookTitle().isEmpty()) {
			bookFound = bookService.getBookById(model.getBookId()).orElseThrow(()->new ResourceNotFoundException("Book","title", model.getBookTitle()));
		}
		if(bookFound!=null) {
			Review review = new Review(1L,model.getUserId(),model.getReviewDescription());
			bookFound.getReviews().add(review);
			updatedBook = bookService.addBookReview(bookFound);
		}
		return updatedBook;
	}

}
