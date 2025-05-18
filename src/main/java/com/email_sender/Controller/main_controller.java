package com.email_sender.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.email_sender.services.email_service;




@Controller
public class main_controller {

    @Autowired
    private email_service emailService;

    @GetMapping("/")
    public String getMethodName() {
        return "home";
    }
    
    @PostMapping("/submit")
    public String postMethodName(@RequestParam String email) {
        try{
            // Call the email service to send the email
            emailService.sendContactEmail(email);
        }
        catch(Exception e){
            System.out.println("Error sending email: " + e.getMessage());
        }
        return "home";
    }
    
}
