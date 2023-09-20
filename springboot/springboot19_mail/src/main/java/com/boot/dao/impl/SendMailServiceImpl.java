package com.boot.dao.impl;

import com.boot.dao.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Alonso
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    private String from = "976570125@qq.com";//发送者
    private String to = "1981278702@qq.com";//接收者
    private String subject = "测试邮件";
    private String context = "<a href='https://www.baidu.com'>点击跳转</a>";

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);

            //发送附件
            File file = new File("D:\\idea_projects\\springboot\\springboot19_mail\\target\\springboot19_mail-0.0.1-SNAPSHOT.jar");
            File file1 = new File("D:\\idea_projects\\springboot\\springboot19_mail\\src\\main\\resources\\1.jpg");
            helper.addAttachment(file.getName(), file);
            helper.addAttachment("图片：", file1);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
