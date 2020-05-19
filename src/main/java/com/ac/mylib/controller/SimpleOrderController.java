package com.ac.mylib.controller;

import com.ac.mylib.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleOrderController {
    @Autowired
    private MailService mailService;

    private MailSender mailSender;

    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    @GetMapping(path = "/send/qq")
    public void sendToQQ() {
        String to = "462148780@qq.com";
        String subject = "Hello subject";
        String content = "This is content test on 2020/05/19 22:32";
        mailService.sendSimpleMail(to, subject, content);
    }

    @GetMapping(path = "/send/163")
    public void sendTo163() {
        String to = "njfu126@163.com";
        String subject = "Hello subject";
        String content = "This is content test on 2020/05/19 22:32";
        mailService.sendSimpleMail(to, subject, content);
    }

}
