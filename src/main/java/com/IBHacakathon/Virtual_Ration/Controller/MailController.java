package com.IBHacakathon.Virtual_Ration.Controller;

import com.IBHacakathon.Virtual_Ration.Model.User;
import com.IBHacakathon.Virtual_Ration.Repository.UserRepository;
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

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    private String Otp;

    Map<String,String> OTPs = new HashMap<>();

    @Autowired
    private MailService mailService;// = new MailService();

    @Value("${otp.length}")
    int otplength;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getOtp/{mailId}")
    public String validateMail(@PathVariable(value = "mailId") String mailId, HttpSession session){
        String subject = "OTP from RATION India";
        User user = userRepository.findByEmail(mailId);
        if(user == null){
            return "user with email id : "+mailId+" is not present";
        }
        session.setAttribute("mailId",mailId);
        Otp = RandomString.generateString(otplength);
        String message = "Hi your OTP is "+ Otp;
        OTPs.put(mailId, Otp);
        return mailService.sendMail(mailId,subject,message);
    }

    @GetMapping("/validate/{otp}")
    public boolean validateOtp(@PathVariable(value = "otp") String otp, HttpSession session){
        String id = (String)session.getAttribute("mailId");
        //System.out.println(id+"  "+OTPs.get(id)+"  ->  "+otp);
        if(OTPs.get(id).equals(otp)){
            return true;
        }
        else{
            return false;
        }
    }

}
