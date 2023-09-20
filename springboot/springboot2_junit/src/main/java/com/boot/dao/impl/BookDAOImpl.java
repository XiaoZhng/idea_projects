package com.boot.dao.impl;

import com.boot.dao.BookDAO;
import org.springframework.stereotype.Repository;

/**
 * @author Alonso
 */
@Repository
public class BookDAOImpl implements BookDAO {
    @Override
    public void save() {
        System.out.println("Book save()...");
    }
}
