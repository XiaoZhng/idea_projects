package com.boot.service.impl;

import com.boot.domain.SMSCode;
import com.boot.service.SMSCodeService;
import com.boot.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * @author Alonso
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

//    @Override
//    @CachePut(value = "smsCode", key = "#tel")
//    public String getCode(String tel) {
//        String code = codeUtils.generator(tel);
//        return code;
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        //取出内存中的验证码与传递过来的验证码对比，如果相同，返回true
//        String cacheCode = codeUtils.jyCode(smsCode.getTel());
//        String code = smsCode.getCode();
//        return code.equals(cacheCode);
//    }


    //以下是springboot中使用 xmemcached

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String getCode(String tel) {
        String code = codeUtils.generator(tel);
        try {
            memcachedClient.set(tel, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getTel().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }
}
