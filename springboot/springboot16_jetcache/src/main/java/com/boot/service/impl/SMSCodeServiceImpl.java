package com.boot.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.boot.domain.SMSCode;
import com.boot.service.SMSCodeService;
import com.boot.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    //自定义缓存空间
    //expire：过期时间(秒)
    //@CreateCache(area = "sms", name = "jetCache_", expire = 10)

    //本地缓存
    @CreateCache(name = "jetCache_", expire = 3600, cacheType = CacheType.LOCAL)
    private Cache<String, String> jetCache;

    @Override
    public String getCode(String tel) {
        String code = codeUtils.generator(tel);
        //放入jetCache缓存
        jetCache.put(tel, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //从jetCache缓存中取
        String code = jetCache.get(smsCode.getTel());;
        return smsCode.getCode().equals(code);
    }
}
