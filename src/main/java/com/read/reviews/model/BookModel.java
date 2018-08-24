package com.read.reviews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {
	
	private Long bookId;
	private String bookTitle;
	private String userId;
	private String reviewDescription;

}
