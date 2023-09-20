package com.spring.aop;

/**
 * @author Alonso
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void add(int x, int y) {
        System.out.println(x + y);
    }
    @Override
    public void update(String id) {
        System.out.println(id);
    }
}
