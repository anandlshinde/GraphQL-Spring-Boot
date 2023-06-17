package com.graphqlclient.service.impl;

import com.graphqlclient.model.Book;
import com.graphqlclient.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final HttpGraphQlClient httpGraphQlClient;

    public BookServiceImpl(){
        WebClient webClient=WebClient.builder()
                .baseUrl("localhost:8009/graphql")
                .build();
        httpGraphQlClient=HttpGraphQlClient.builder(webClient).build();
    }
    @Override
    public List<Book> getBooks() {
        String document="""
                        query{
                                    allBooks{
                                    id
                                    name
                                    pages
                                    price
                                    }
                                
                                }
                """;
        String allBooks = "allBooks";
        List<Book> bookList = httpGraphQlClient.document(document)
                .retrieve(allBooks).toEntityList(Book.class).block();

        return bookList;
    }

    @Override
    public Book getBook(int bookId) {
        String document="""
                        query{
                                    getBook(bookId: 0){
                                         id
                                         name
                                         pages
                                         }
                                
                                }
                """;
        String newDocument = document.replace("0", String.valueOf(bookId));
        String getBook = "getBook";
        Book book = httpGraphQlClient.document(newDocument)
                .retrieve(getBook).toEntity(Book.class).block();
        return book;
    }
}
