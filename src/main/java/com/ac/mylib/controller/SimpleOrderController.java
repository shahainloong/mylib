package com.ac.mylib.controller;

import com.ac.mylib.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleOrderController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleOrderController.class);
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
        String content = "This is content test on 2020/05/20 0945";
        mailService.sendSimpleMail(to, subject, content);
    }

    @GetMapping(path = "/send/163")
    public void sendTo163() {
        String to = "njfu126@163.com";
        String subject = "Hello subject";
        String content = "This is content test on 2020/0520 0945";
        mailService.sendSimpleMail(to, subject, content);
        logger.info("【文本邮件】成功发送！to={}", to);
    }

    @GetMapping(path = "/send/sap")
    public void sendToSap() {
        String to = "hailong.sha@sap.com";
        String subject = "Hello subject";
        String content = "This is content test on 2020/0520 0945";
        mailService.sendSimpleMail(to, subject, content);
    }
}
