package com.example.servicetwo.services;

import com.example.servicetwo.entites.MessageModel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@RabbitListener(queues = "test-queue")
public class RabbitConsumer{
//    @Override
//    public void onMessage(Message message) {
//        try {
//            MessageModel object = (MessageModel) new Jackson2JsonMessageConverter().fromMessage(message);
//            System.out.println(message.toString());
//        } catch (Exception e) {
//            // обработка ошибок
//        }
//
//    }
    @RabbitHandler
    public void handleMessage(Message message) throws IOException {
//        System.out.println("Received message: " + object);
        String s = new String(message.getBody(), "UTF-8");
        System.out.println(message.toString());
    }

}
