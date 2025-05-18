package com.email_sender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class email_service {
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Application for Java Developer/SDE Position");
        helper.setText(
            "Hii,\n"+
            "I am looking for Java Developer/sde position please find my attached resume for the Java Developer position. I am currently having over 2 years of experience in backend development using Java and Spring Boot and other microservices technology.\n\n"+
            "I am looking forward to hearing from you about the position.\n" +
            "Please let me know if you have any questions or any other information required.\n\n" +
            "Thanks and regards.\n" +
            "Ankit Jha\n" +
            "+91-8744018978\n" +
            "ankitjha481@gmail.com\n"+
            "https://www.linkedin.com/in/ankit-jha-5330621ab/"
        );

        // Attach the resume
        ClassPathResource file = new ClassPathResource("Ankit Jha Resume.pdf");
        helper.addAttachment("Ankit Jha Resume.pdf", file);

        mailSender.send(message);
    }
}
