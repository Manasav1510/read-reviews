package com.read.reviews.entity;

import java.util.List;

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
	private Long bookId;
	private String title;
	private String authorName;
	private String publisher;
	private List<String> tags;
	private List<Review> reviews;
	
	
}
