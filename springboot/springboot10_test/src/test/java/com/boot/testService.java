package com.boot;

import com.boot.domain.Book;
import com.boot.domain.testCase;
import com.boot.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alonso
 */
@SpringBootTest
@Transactional
//@Rollback(value = false)
public class testService {

    @Autowired
    private BookService bookService;

    @Autowired
    private testCase testCase;

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("三体1");
        book.setType("科幻1");
        book.setAuthor("刘慈欣1");
        bookService.save(book);
    }

    @Test
    public void test(){
        System.out.println(testCase);
    }
}
