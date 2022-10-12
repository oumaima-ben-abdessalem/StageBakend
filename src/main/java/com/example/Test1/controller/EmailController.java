package com.example.Test1.controller;

import com.example.Test1.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/sendmail")
    public void sendmail(@PathParam("address") String address) {

        emailService.sendMail(address, "assurance tarification", "hello oumaima! " +
                "welcome to our website for more informations we gonna contact you" +
                " as soon as possible to negociate with you !");

        //return "emailsent";
    }
}
