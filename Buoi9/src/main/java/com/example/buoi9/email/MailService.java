package com.example.buoi9.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class MailService implements MailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    @Override
    public String sentMail(String to, String email) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, StandardCharsets.UTF_8.name());
        messageHelper.setSubject("Phan");
        messageHelper.setFrom("duongboygh10@gmail.com");
        messageHelper.setText(email, true);
        messageHelper.setTo(to);
        javaMailSender.send(mailMessage);
        return "Sent mail succesfull";
    }
}
