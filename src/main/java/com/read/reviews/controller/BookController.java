package com.read.reviews.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.read.reviews.entity.Book;
import com.read.reviews.entity.Review;
import com.read.reviews.exception.ResourceNotFoundException;
import com.read.reviews.service.BookService;
import com.read.reviews.serviceImpl.NextSequenceService;


@RestController
@RequestMapping("/readreviews")
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value="auth/books",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void addBook(@RequestBody @Valid Book book ) {
		bookService.addBook(book);
	}
	
	@GetMapping(value="/books",produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Iterable<Book> getBooks(){
		return bookService.getBooks();
		
	}
	
	@DeleteMapping(value="auth/books/{value}")
	public void deleteBook(@PathVariable String value){
		 bookService.deleteBook(value);
		
	}
	
	@DeleteMapping(value="auth/books/all")
	public void deleteAllBook(){
		 bookService.deleteAllBook();
		
	}
	
	@GetMapping(value="/books/{bookId}")
	public Book getBook(@PathVariable String bookId){
		return bookService.getBookById(bookId).orElseThrow(()->new ResourceNotFoundException("Book","id", bookId));
	}
	
	@GetMapping(value="/books/search/{searchValue}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Book> search(@PathVariable String searchValue){
		return bookService.searchBookByAuthorOrTitleOrPublisherOrIsbn(searchValue).orElseThrow(()->new ResourceNotFoundException("Book","search value", searchValue));
	}
	
	@PutMapping(value="auth/books/review/{isbn}/{description}",produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
	public Book addBookReview(@PathVariable String isbn,@PathVariable String description ){
		Book bookFound = null;
		Book updatedBook = null;
		if(isbn!=null) {
			bookFound = bookService.getBookByIsbn(isbn).orElseThrow(()->new ResourceNotFoundException("Book","id", isbn));
		}
		if(bookFound!=null) {
			Review review = new Review();
			review.setDescription(description);
			review.setUserId("admin");
			review.setDate(LocalDate.now());
			review.setReviewId(nextSequenceService.getNextSequence("customSequences"));
			bookFound.getReviews().add(review);
			updatedBook = bookService.addBookReview(bookFound);
		}
		return updatedBook;
	}

}
