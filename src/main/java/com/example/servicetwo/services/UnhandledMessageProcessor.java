package com.example.servicetwo.services;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class UnhandledMessageProcessor implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Unhandled message: " + message);
    }
}
