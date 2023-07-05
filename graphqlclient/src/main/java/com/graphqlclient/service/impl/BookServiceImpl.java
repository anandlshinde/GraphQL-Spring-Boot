package com.graphqlclient.service.impl;

import com.graphqlclient.model.Book;
import com.graphqlclient.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.client.ClientResponseField;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
//https://docs.spring.io/spring-graphql/docs/current-SNAPSHOT/reference/html/#samples
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
        List<Book> allBooks1 = httpGraphQlClient.document(document)
                //  .retrieve(allBooks).toEntityList(Book.class).block();

                .execute()


                .map(response -> {
                    if (!response.isValid()) {
                        // Request failure...
                        System.out.println("Failed not valid response");
                    }

                    ClientResponseField field = response.field("allBooks");
                    if (!field.hasValue()) {
                        if (field.getError() != null) {
                            System.out.println("feild has error");
                        } else {
                            // Optional field set to null...
                        }
                    }

                    return field.toEntityList(Book.class);
                }).block();

        return allBooks1;
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
