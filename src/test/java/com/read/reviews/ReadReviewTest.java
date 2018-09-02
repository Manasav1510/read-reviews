/*package com.read.reviews;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.read.reviews.controller.BookController;
import com.read.reviews.entity.Book;
import com.read.reviews.service.BookService;
import com.read.reviews.serviceImpl.NextSequenceService;

@RunWith(SpringRunner.class) 
@WebMvcTest(value=BookController.class, secure=false)
public class ReadReviewTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private BookService bookService;
	
	@MockBean
	private NextSequenceService nextSequenceService;
	
	
	Optional<Book> mockBook = Optional.of(new Book("001","sample book","mansa","peer"));
	
	String exampleBookJson = "{\"isbn\":\"001\",\"title\":\"sample book\",\"authorName\":\"mansa\",\"publisher\":\"peer\"}";
	
	@Test
	public void retrieveBookDetails() throws Exception{
		Mockito.when(bookService.getBookByIsbn(Mockito.anyString())).thenReturn(mockBook);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/001")
					.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{isbn:001,title:sample Book,authorName:mansa,publisher:peer}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);

	
	}
	
	
}
*/