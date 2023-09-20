package com.boot.dao.impl;

import com.boot.dao.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Alonso
 */
//@Service
public class SendMailServiceImpl2 implements SendMailService {

    private String from = "976570125@qq.com";//发送者
    private String to = "1981278702@qq.com";//接收者
    private String subject = "测试邮件";
    private String text = "测试邮件正文";

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
