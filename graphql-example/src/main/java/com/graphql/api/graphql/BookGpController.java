package com.graphql.api.graphql;

import com.graphql.dto.BookInput;
import com.graphql.entity.Book;
import com.graphql.mapper.BookMapper;
import com.graphql.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class BookGpController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        return bookService.saveBook(bookMapper.bookInputToBook(book));
    }

    @QueryMapping("allBooks")
    public List<Book> getBook() {
    return bookService.getBookList();
    }

    @QueryMapping("getBook")
    public Optional<Book> getBook(@Argument int bookId) {
        return bookService.getBookById(bookId);
    }

//https://github.com/graphql-java-generator/GraphQL-Forum-Maven-Tutorial-server

}
/*
@Getter
@Setter
 class BookInput {
    private String name;
    private String description;
    private double price;
    private String author;
    private int pages;
}*/
