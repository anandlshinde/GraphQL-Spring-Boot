package com.graphqlclient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Book {

    private int id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String  author;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int pages;
}
