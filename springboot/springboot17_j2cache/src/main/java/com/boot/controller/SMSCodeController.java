package com.boot.controller;

import com.boot.domain.SMSCode;
import com.boot.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alonso
 */
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tel){
        String code = smsCodeService.getCode(tel);
        System.out.println("=============code= " + code);
        return code;
    }

    @PostMapping
    public boolean checkCode(SMSCode smsCode){
        boolean b = smsCodeService.checkCode(smsCode);
        System.out.println(b);
        return b;
    }
}
