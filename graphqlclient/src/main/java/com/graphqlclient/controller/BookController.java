package com.graphqlclient.controller;

import com.graphqlclient.model.Book;
import com.graphqlclient.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping("books")
    public List<Book> getBooks(){
       return bookService.getBooks();
    }
}
