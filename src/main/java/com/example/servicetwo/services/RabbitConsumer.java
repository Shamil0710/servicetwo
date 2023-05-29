package com.example.servicetwo.services;

import com.example.servicetwo.entites.Message;
import com.example.servicetwo.entites.MessageModel;
import com.example.servicetwo.entites.Status;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Log4j2
@Component
public class RabbitConsumer {
    private final MessageService messageService;

    @Autowired
    public RabbitConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @RabbitListener(queues = "test-queue")
    public void handleMessage(MessageModel message) throws IOException {
        messageService.checkServiceStatus(Status.fromMessageModel(message));
        if (message.getMassage() != null) {
            messageService.putMessage(Message.fromMessageModel(message));
        }
    }
}
