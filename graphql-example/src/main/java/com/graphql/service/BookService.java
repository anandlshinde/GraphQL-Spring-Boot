package com.graphql.service;

import com.graphql.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

     Book saveBook(Book book);
     List<Book> getBookList();
     Optional<Book> getBookById(int id);

}
