package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Utility.MailService;
import com.IBHacakathon.Virtual_Ration.Utility.RandomString;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private MailService mailService;// = new MailService();

    @Value("${otp.length}")
    int otplength;

    @GetMapping("/getOtp/{mailId}")
    public boolean validateMail(@PathVariable(value = "mailId") String mailId){
        String subject = "OTP from RATION India";
        Otp = RandomString.generateString(otplength);
        String message = "Hi your OTP is "+ Otp;
        return mailService.sendMail(mailId,subject,message);
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

}
