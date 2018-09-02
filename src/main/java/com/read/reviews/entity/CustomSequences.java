package com.read.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "customSequences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomSequences {
    @Id
    private String id;
    private int seq;
}