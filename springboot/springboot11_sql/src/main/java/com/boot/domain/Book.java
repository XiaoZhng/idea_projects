package com.boot.domain;

import lombok.Data;

/**
 * @author Alonso
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String author;
}
