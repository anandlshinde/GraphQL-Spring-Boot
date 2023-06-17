package com.graphql.mapper;

import com.graphql.dto.BookInput;
import com.graphql.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book bookInputToBook(BookInput bookInput);
}
