package com.graphqlclient.service;

import com.graphqlclient.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();
}
