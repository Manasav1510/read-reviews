package com.read.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	@Id
	private Long reviewId;
	private String userId;
	private String description;
}
