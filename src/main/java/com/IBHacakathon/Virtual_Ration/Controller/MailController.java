package com.IBHacakathon.Virtual_Ration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/mail")
public class MailController {
    private String Otp;
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/getOtp/{mailId}")
    public boolean validateMail(@PathVariable(value = "mailId") String mailId){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailId);

        msg.setSubject("OTP from RATION India");
        Otp = generateOtp();
        msg.setText("Hi your OTP is "+ Otp);
        javaMailSender.send(msg);
        return true;
    }

    @GetMapping("/validate/{otp}")
    public boolean validateOtp(@PathVariable(value = "otp") String otp){
        if(otp.equals(Otp)){
            return true;
        }
        else{
            return false;
        }
    }

    public String generateOtp(){
        List<Character> alphabet = generator();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<5;i++){
           sb.append(alphabet.get(random.nextInt(alphabet.size())));
        }
         return sb.toString();
    }
    public List<Character> generator(){
        List<Character> list = new ArrayList<>();
        for(int i='a';i<='z';i++){
            list.add((char)i);
        }
        for(int i='A';i<='Z';i++){
            list.add((char)i);
        }
        for(int i=0;i<=9;i++){
            list.add((char)(i+'0'));
        }
        return list;
    }
}
