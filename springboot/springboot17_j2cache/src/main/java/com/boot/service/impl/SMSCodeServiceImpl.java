package com.boot.service.impl;

import com.boot.domain.SMSCode;
import com.boot.service.SMSCodeService;
import com.boot.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String getCode(String tel) {
        String code = codeUtils.generator(tel);
        cacheChannel.set("sms", tel, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms", smsCode.getTel()).asString();
        return smsCode.getCode().equals(code);
    }
}
