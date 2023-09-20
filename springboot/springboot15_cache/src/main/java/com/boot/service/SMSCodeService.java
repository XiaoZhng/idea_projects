package com.boot.service;

import com.boot.domain.SMSCode;

/**
 * @author Alonso
 */
public interface SMSCodeService {

    String getCode(String tel);
    boolean checkCode(SMSCode smsCode);
}
