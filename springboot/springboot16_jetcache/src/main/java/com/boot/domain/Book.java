package com.boot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Alonso
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private String author;
}
