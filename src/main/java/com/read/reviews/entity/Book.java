package com.read.reviews.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	private String isbn;
	public Book(String isbn, @NotNull String title, @NotNull String authorName, @NotNull String publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authorName = authorName;
		this.publisher = publisher;
	}
	@NotNull
	private String title;
	@NotNull
	private String authorName;
	@NotNull
	private String publisher;
	private List<Review> reviews;
	
	
}
