package com.read.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	@Id
	private String authorId;
	private String firstName;
	private String lastName;
	private String city;
	private String email;

}
