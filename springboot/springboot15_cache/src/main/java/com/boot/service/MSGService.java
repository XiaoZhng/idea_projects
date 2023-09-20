package com.boot.service;

/**
 * @author Alonso
 */

public interface MSGService {
    String get(String tel);
    boolean check(String tel, String code);
}
