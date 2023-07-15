package com.example.buoi9.controller;

import com.example.buoi9.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sent")
    public ResponseEntity<?> sentMail(@RequestParam String to, @RequestParam String text) throws MessagingException {
        return ResponseEntity.ok().body(mailService.sentMail(to,text));
    }
}
