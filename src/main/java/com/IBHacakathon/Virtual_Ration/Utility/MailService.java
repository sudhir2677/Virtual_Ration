package com.IBHacakathon.Virtual_Ration.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMail(String mailId, String subject, String message){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailId);
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
        return "message send";
    }
}
