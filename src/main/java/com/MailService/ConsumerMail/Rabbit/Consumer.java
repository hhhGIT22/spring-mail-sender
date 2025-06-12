package com.MailService.ConsumerMail.Rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.MailService.ConsumerMail.Mailing.Email;

@Service
public class Consumer {

    private final Email email;
    @Value("${email}")
    private String email_reciever;

    public Consumer(Email email) {
        this.email = email;
    }

    @RabbitListener(queues = "failed-url")
    public void receiveMessage(String url) {
        System.out.println("Received failed URL: " + url);
        email.sendSimpleEmail(
        		email_reciever, 
            "URL failed", 
            "The following URL has failed: " + url
        );
    }
}
