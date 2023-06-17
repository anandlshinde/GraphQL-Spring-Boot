package com.graphql.api.rest;

import com.graphql.entity.Book;
import com.graphql.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books/")
@AllArgsConstructor
public class BookController {

    private  BookService bookService;

    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    @GetMapping("/books")
    public List<Book> getBook() {
    return bookService.getBookList();
    }

    @GetMapping("/book/{bookId}")
    public Optional<Book> getBook(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }
}
