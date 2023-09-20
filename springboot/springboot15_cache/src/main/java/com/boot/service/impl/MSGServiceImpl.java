package com.boot.service.impl;

import com.boot.dao.BookDAO;
import com.boot.domain.Book;
import com.boot.service.BookService;
import com.boot.service.MSGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Alonso
 * 模拟 缓存机制
 */
@Service
public class MSGServiceImpl implements MSGService {

    //模拟 缓存机制
    private HashMap<String, String> cache = new HashMap<>();

    @Override
    public String get(String tel) {
        //传入 tel后，生成 code验证码
        String code = tel.substring(tel.length() - 6);
        //把验证码放入 cache
        cache.put(tel, code);
        return code;
    }

    @Override
    public boolean check(String tel, String code) {
        //验证传入的 code是否是 cache中的 code
        String QueryCode = cache.get(tel);
        return QueryCode.equals(code);
    }
}
