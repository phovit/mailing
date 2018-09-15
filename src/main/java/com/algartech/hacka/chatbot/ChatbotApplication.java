package com.algartech.hacka.chatbot;

import com.algartech.hacka.chatbot.service.EmailService;
import com.algartech.hacka.chatbot.service.MailingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
        MailingService.scheduleMailing();

    }
}
