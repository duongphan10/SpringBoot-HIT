package com.example.buoi9.schedule;

import com.example.buoi9.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ScheduleMail {
    @Autowired
    private MailService mailService;
    @Scheduled(fixedRate = 1000)
    void sentMailSchedule() throws MessagingException {
        mailService.sentMail("duongboygh10@gmail.com","HunterK");
    }
}
