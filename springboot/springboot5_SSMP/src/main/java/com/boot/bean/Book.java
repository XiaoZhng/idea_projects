package com.boot.bean;

import lombok.Data;
import org.springframework.stereotype.Controller;

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
