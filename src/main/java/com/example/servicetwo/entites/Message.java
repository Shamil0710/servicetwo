package com.example.servicetwo.entites;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Status serviceId;

    @Column(name = "messages")
    private String messages;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    public static Message fromMessageModel(MessageModel messageModel) { ;
        Status status = Status.builder()
                .serviceId(messageModel.getServiceId())
                .build();
        Message message = Message.builder()
                .serviceId(status)
                .messages(messageModel.getMassage())
                .timeStamp(LocalDateTime.now())
                .build();
        return message;
    }
}
